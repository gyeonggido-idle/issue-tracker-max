package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.repository.CommentRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.Comment;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.Filter;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.Issue;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository.FilteredIssueRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository.IssueRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository.vo.IssueVO;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.condition.IssueCreateCondition;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.condition.IssueStatusCondition;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.condition.IssueUpdateCondition;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.information.FilterInformation;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.label.repository.LabelRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.label.repository.VO.LabelVO;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.member.repository.MemberRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.stat.repository.StatRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.stat.repository.vo.StatVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IssueService {

    private final StatRepository statRepository;
    private final IssueRepository issueRepository;
    private final LabelRepository labelRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final FilteredIssueRepository filteredIssueRepository;

    public FilterInformation read(String filterCondition) {
        StatVO statVO = statRepository.countOverallStats();
        Filter filter = Filter.from(filterCondition);
        List<IssueVO> issueVOs = filteredIssueRepository.findByFilter(filter);
        List<Long> issueIds = getIssueIds(issueVOs);
        Map<Long, List<LabelVO>> labelVOs = labelRepository.findAllByIssueIds(issueIds);
        Map<Long, List<String>> assigneeProfiles = memberRepository.findAllProfilesByIssueIds(issueIds);

        return FilterInformation.from(statVO, issueVOs, labelVOs, assigneeProfiles, filterCondition);
    }

    public void create(IssueCreateCondition condition) {
        Issue issue = IssueCreateCondition.toIssue(condition);
        Long createdId = issueRepository.createIssue(issue);
        Comment comment = IssueCreateCondition.toComment(createdId, condition);
        Long fileId = null;
        if (comment.isFileExist()) {
            fileId = commentRepository.updateFile(comment.getFile());
        }
        if (comment.isContentsExist()) {
            commentRepository.createComment(fileId, comment);
        }
        if (condition.getAssignees() != null) {
            memberRepository.addIssueAssignees(createdId, condition.getAssignees());
        }
        if (condition.getLabels() != null) {
            labelRepository.addIssueLabels(createdId, condition.getLabels());
        }
    }

    public void updateIssuesStatus(IssueStatusCondition condition) {
        issueRepository.updateIssuesStatus(IssueStatusCondition.to(condition));
    }

    public void deleteIssue(Long issueId) {
        issueRepository.deleteIssue(issueId);
    }

    public void updateIssue(IssueUpdateCondition condition) {
        issueRepository.updateIssue(IssueUpdateCondition.to(condition));
        if (!condition.getAssignees().isEmpty()) {
            memberRepository.updateIssueAssignees(condition.getIssueId(), condition.getAssignees());
        }
        if (!condition.getLabels().isEmpty()) {
            labelRepository.updateIssueLabels(condition.getIssueId(), condition.getLabels());
        }
    }

    private List<Long> getIssueIds(List<IssueVO> issueVOs) {
        return issueVOs.stream()
                .map(IssueVO::getId)
                .collect(Collectors.toUnmodifiableList());
    }
}
