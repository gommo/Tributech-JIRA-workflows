package au.tributech.atlassian.jira.workflow;

import com.atlassian.jira.workflow.condition.AbstractJiraCondition;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.WorkflowException;
import org.apache.log4j.Logger;

import java.util.Map;

public class WorkRemainingIsNullCondition extends AbstractJiraCondition {

    private static final Logger log = Logger.getLogger(WorkRemainingIsNullCondition.class);

    public boolean passesCondition(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
        return getIssue(transientVars).getEstimate() == 0;
    }
}
