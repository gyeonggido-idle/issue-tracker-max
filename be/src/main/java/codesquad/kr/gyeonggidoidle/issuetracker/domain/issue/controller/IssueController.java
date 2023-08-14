package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.controller;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.controller.request.IssueCreateRequest;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.controller.request.IssueStatusRequest;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.controller.request.IssueUpdateRequest;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.controller.response.ApiResponse;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.controller.response.FilterResponse;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public FilterResponse readFiltedIssues(@RequestParam(name = "q", required = false) String encodedQuery) {
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            return FilterResponse.from(issueService.readFilteredIssues("is:open"));
        }
        String filterCondition = UriUtils.decode(encodedQuery, "UTF-8");
        return FilterResponse.from(issueService.readFilteredIssues(filterCondition));
    }

    @PostMapping
    public ApiResponse create(@RequestBody IssueCreateRequest request, HttpServletRequest httpServletRequest) {
        issueService.createIssue(IssueCreateRequest.to(request,
                        Long.valueOf(String.valueOf(httpServletRequest.getAttribute("memberId")))
                )
        );
        return ApiResponse.success(HttpStatus.OK);
    }

    @PatchMapping
    public ApiResponse updateIssuesStatus(@RequestBody IssueStatusRequest request) {
        issueService.updateIssuesStatus(IssueStatusRequest.to(request));
        return ApiResponse.success(HttpStatus.OK);
    }

    @PutMapping("/{issueId}")
    public ApiResponse updateIssue(@PathVariable Long issueId, @RequestBody IssueUpdateRequest request) {
        issueService.updateIssue(IssueUpdateRequest.to(issueId, request));
        return ApiResponse.success(HttpStatus.OK);
    }

    @PatchMapping("/{issueId}")
    public ApiResponse updateIssueStatus(@PathVariable Long issueId, @RequestBody IssueStatusRequest request) {
        issueService.updateIssuesStatus(IssueStatusRequest.to(issueId, request));
        return ApiResponse.success(HttpStatus.OK);
    }

    @DeleteMapping("/{issueId}")
    public ApiResponse delete(@PathVariable Long issueId) {
        issueService.deleteIssue(issueId);
        return ApiResponse.success(HttpStatus.OK);
    }
}
