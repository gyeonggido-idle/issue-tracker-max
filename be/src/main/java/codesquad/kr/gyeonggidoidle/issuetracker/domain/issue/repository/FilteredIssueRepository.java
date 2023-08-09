package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.FilterCondition;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository.vo.IssueVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FilteredIssueRepository {

    private final SqlSessionFactory sqlSessionFactory;

    public List<IssueVO> findByFilter(FilterCondition filterCondition) {
        List<IssueVO> filteredIssues = null;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            filteredIssues = sqlSession.selectList(filter.findByfilter, filterCondition);
        }
        return filteredIssues;
    }
}
