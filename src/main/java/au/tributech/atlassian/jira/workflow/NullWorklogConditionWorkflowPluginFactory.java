package au.tributech.atlassian.jira.workflow;

import com.atlassian.jira.plugin.workflow.WorkflowPluginConditionFactory;
import com.opensymphony.workflow.loader.AbstractDescriptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NullWorklogConditionWorkflowPluginFactory implements WorkflowPluginConditionFactory {

    public Map<String, ?> getVelocityParams(String s, AbstractDescriptor abstractDescriptor) {
        return new HashMap();
    }

    public Map<String, ?> getDescriptorParams(Map<String, Object> stringObjectMap) {
        return Collections.EMPTY_MAP;
    }
}
