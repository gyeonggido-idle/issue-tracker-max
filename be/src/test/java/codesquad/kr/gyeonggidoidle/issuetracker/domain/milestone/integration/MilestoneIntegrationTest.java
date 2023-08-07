package codesquad.kr.gyeonggidoidle.issuetracker.domain.milestone.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import codesquad.kr.gyeonggidoidle.issuetracker.annotation.IntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@IntegrationTest
class MilestoneIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("열린 마일스톤의 모드 정보를 가지고 온다.")
    @Test
    void testReadOpenMilestones() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/milestones/open"));

        resultActions
                .andExpect(status().isOk())
                .andExpectAll(
                        jsonPath("$.openMilestoneCount").value(3),
                        jsonPath("$.closeMilestoneCount").value(1),
                        jsonPath("$.labelCount").value(4),
                        jsonPath("$.milestones.length()").value(3),
                        jsonPath("$.milestones.[0].name").value("마일스톤 0")
                );
    }

    @DisplayName("닫힌 마일스톤의 모드 정보를 가지고 온다.")
    @Test
    void testReadClosedMilestones() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/milestones/closed"));

        resultActions
                .andExpect(status().isOk())
                .andExpectAll(
                        jsonPath("$.openMilestoneCount").value(3),
                        jsonPath("$.closeMilestoneCount").value(1),
                        jsonPath("$.labelCount").value(4),
                        jsonPath("$.milestones.length()").value(1),
                        jsonPath("$.milestones.[0].name").value("마일스톤 2")
                );
    }
}
