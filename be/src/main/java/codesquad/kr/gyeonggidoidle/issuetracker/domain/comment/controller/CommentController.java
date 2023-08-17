package codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.controller;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

}
