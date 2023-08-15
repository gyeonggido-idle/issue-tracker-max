package codesquad.kr.gyeonggidoidle.issuetracker.domain.filter.controller.response;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.filter.service.information.FilterInformation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FilterResponse {

    private final List<AssigneeFilterResponse> assignees;
    @JsonInclude(Include.NON_NULL)
    private final List<AuthorFilterResponse> authors;
    private final List<LabelFilterResponse> labels;
    private final List<MilestoneFilterResponse> milestones;

    @Builder
    private FilterResponse(List<AssigneeFilterResponse> assignees, List<AuthorFilterResponse> authors,
                           List<LabelFilterResponse> labels, List<MilestoneFilterResponse> milestones) {
        this.assignees = assignees;
        this.authors = authors;
        this.labels = labels;
        this.milestones = milestones;
    }

    public static FilterResponse from(FilterInformation information) {
        return FilterResponse.builder()
                .assignees(AssigneeFilterResponse.from(information.getAssigneeFilterInformations()))
                .authors(AuthorFilterResponse.from(information.getAuthorFilterInformations()))
                .labels(LabelFilterResponse.from(information.getLabelFilterInformations()))
                .milestones(MilestoneFilterResponse.from(information.getMilestoneFilterInformations()))
                .build();
    }
}
