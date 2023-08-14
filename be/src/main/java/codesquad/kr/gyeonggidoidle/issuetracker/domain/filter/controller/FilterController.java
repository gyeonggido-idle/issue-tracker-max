package codesquad.kr.gyeonggidoidle.issuetracker.domain.filter.controller;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.filter.controller.response.FilterListResponse;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/filters")
public class FilterController {

    private final IssueService issueService;

    @GetMapping("/main")
    public FilterListResponse readFilters() {
        return FilterListResponse.from(issueService.readFilters());
    }

    @GetMapping("/detail")
    public FilterListResponse readFiltersFromIssue() {
        return FilterListResponse.from(issueService.readFiltersFromIssue());
    }
}
