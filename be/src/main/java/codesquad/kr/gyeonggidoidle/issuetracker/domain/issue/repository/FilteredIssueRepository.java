package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FilteredIssueRepository {

    private final SqlSessionFactory sqlSessionFactory;

}
