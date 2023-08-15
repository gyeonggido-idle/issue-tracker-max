package codesquad.kr.gyeonggidoidle.issuetracker.domain.filter.service;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.filter.service.information.FilterInformation;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.label.repository.LabelRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.label.repository.VO.LabelDetailsVO;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.member.repository.MemberRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.member.repository.vo.MemberDetailsVO;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.milestone.repository.MilestoneRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.milestone.repository.vo.MilestoneDetailsVO;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.stat.repository.StatRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.stat.repository.vo.IssueByMilestoneVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FilterService {

    private final StatRepository statRepository;
    private final MemberRepository memberRepository;
    private final LabelRepository labelRepository;
    private final MilestoneRepository milestoneRepository;

    public FilterInformation readFilters() {
        List<MemberDetailsVO> members = memberRepository.findAllFilters();
        List<LabelDetailsVO> labels = labelRepository.findAllFilters();
        List<MilestoneDetailsVO> milestones = milestoneRepository.findAllFilters();

        return FilterInformation.from(members, members, labels, milestones);
    }

    public FilterInformation readFiltersFromIssue() {
        List<MemberDetailsVO> members = memberRepository.findAllFilters();
        List<LabelDetailsVO> labels = labelRepository.findAllFilters();
        List<MilestoneDetailsVO> milestones = milestoneRepository.findAllFilters();
        List<Long> milestoneIds = getMilestoneIds(milestones);
        Map<Long, IssueByMilestoneVO> issuesCountByMilestoneIds = statRepository.findIssuesCountByMilestoneIds(
                milestoneIds);
        return FilterInformation.from(members, labels, milestones, issuesCountByMilestoneIds);
    }

    private List<Long> getMilestoneIds(List<MilestoneDetailsVO> milestoneDetailsVOs) {
        return milestoneDetailsVOs.stream()
                .map(MilestoneDetailsVO::getId)
                .collect(Collectors.toUnmodifiableList());
    }
}
