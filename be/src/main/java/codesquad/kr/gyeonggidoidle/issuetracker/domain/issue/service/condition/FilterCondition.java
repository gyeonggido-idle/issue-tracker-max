package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.condition;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FilterCondition {

    private final Boolean isOpen;
    private final String assignee;
    private final String label;
    private final String milestone;
    private final String author;

    @Builder
    private FilterCondition(Boolean isOpen, String assignee, String label, String milestone, String author) {
        this.isOpen = isOpen;
        this.assignee = assignee;
        this.label = label;
        this.milestone = milestone;
        this.author = author;
    }
}
