package au.tributech.atlassian.jira.workflow;

import com.atlassian.core.util.map.EasyMap;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.workflow.WorkflowFunctionUtils;
import com.opensymphony.workflow.WorkflowException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class WorkRemainingIsNullConditionTests {
    @Test
    public void conditionShouldPassIfNoRemainingEstimateIs0() {
        givenAnIssueWithRemainingEstimate(0L);
        assertThat(conditionPasses()).isTrue();
    }

    @Test
    public void conditionShouldPassIfRemainingEstimateIsNull() {
        givenAnIssueWithRemainingEstimate(null);
        assertThat(conditionPasses()).isTrue();
    }

    @Test
    public void conditionShouldFailIfRemainingEstimateIsGreaterThanZero() {
        givenAnIssueWithRemainingEstimate(3L);
        assertThat(conditionPasses()).isFalse();
    }

    private boolean conditionPasses() {
        Map inputs = EasyMap.build(WorkflowFunctionUtils.ORIGINAL_ISSUE_KEY, issue);
        try {
            return condition.passesCondition(inputs, null, null);
        } catch (WorkflowException e) {
            Assert.fail(e.getMessage());
        }
        return false;
    }

    private void givenAnIssueWithRemainingEstimate(Long remainingEstimate) {
        given(issue.getEstimate()).willReturn(remainingEstimate);
    }

    @Mock
    private Issue issue;

    private WorkRemainingIsNullCondition condition;

    @BeforeClass
    public void setup() {
         MockitoAnnotations.initMocks(this);
         condition = new WorkRemainingIsNullCondition();
    }
}
