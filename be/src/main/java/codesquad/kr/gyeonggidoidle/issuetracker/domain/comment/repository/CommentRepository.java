package codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.repository;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.Comment;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.comment.repository.result.CommentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final NamedParameterJdbcTemplate template;

    public List<CommentResult> findByIssueId(Long issueId) {
        String sql = "SELECT comment.id, " +
                "comment.author_id, " +
                "author.name AS author_name, " +
                "comment.contents, " +
                "comment.created_at " +
                "FROM comment " +
                "LEFT JOIN member AS author " +
                "ON author.id = comment.author_id " +
                "WHERE comment.issue_id = :issueId " +
                "ORDER BY comment.created_at";

        return template.query(sql, Map.of("issueId", issueId), commentResultRowMapper());
    }

    public Long createComment(Long fileId, Comment comment) {
        String sql = "INERT INTO comment (issue_id, author_id, file_id, contents) " +
                "VALUES (:issue_id, :author_id, :file_id, :contents)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("issue_id", comment.getIssueId())
                .addValue("author_id", comment.getAuthorId())
                .addValue("file_id", fileId)
                .addValue("contents", comment.getContents());
        template.update(sql, params, keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }

    public Long updateFile(String url) {
        String sql = "INSERT INTO file (url) VALUES (:url)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("url", url);
        template.update(sql, params, keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }

    private RowMapper<CommentResult> commentResultRowMapper() {
        return ((rs, rowNum) -> CommentResult.builder()
                .id(rs.getLong("id"))
                .authorId(rs.getLong("author_id"))
                .authorName(rs.getString("author_name"))
                .contents(rs.getString("contents"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .build());
    }
}
