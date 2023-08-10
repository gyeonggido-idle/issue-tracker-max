package codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository;

import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.repository.vo.IssueVO;
import codesquad.kr.gyeonggidoidle.issuetracker.domain.issue.service.condition.FilterCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilteredIssueRepository {

    public List<IssueVO> findByFilter(FilterCondition filterCondition);

    public List<IssueVO> test();
}
