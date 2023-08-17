package codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.service;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.repository.CommentRepository;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.repository.result.CommentResult;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.service.information.CommentInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentInformation> findCommentsByIssueId(Long issueId) {
        List<CommentResult> commentResults = commentRepository.findByIssueId(issueId);

        return CommentInformation.from(commentResults);
    }

}
