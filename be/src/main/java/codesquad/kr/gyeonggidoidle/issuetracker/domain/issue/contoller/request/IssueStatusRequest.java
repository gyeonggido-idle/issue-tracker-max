package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.contoller.request;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.condition.IssueStatusCondition;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;


@Getter
public class IssueStatusRequest {

    @JsonProperty("isOpen")
    private final boolean open;
    private final List<Long> issues;


    @Builder
    private IssueStatusRequest(boolean open, List<Long> issues) {
        this.open = open;
        this.issues = issues;
    }

    public static IssueStatusCondition to(IssueStatusRequest request) {
        return IssueStatusCondition.builder()
                .open(request.open)
                .issueIds(request.getIssues())
                .build();
    }
}
