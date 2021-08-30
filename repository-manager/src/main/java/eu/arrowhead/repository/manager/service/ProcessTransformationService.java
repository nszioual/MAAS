package eu.arrowhead.repository.manager.service;

import eu.arrowhead.api.commons.dto.TransformationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessTransformationService {

    private WorkflowAutomationDriver workflowAutomationDriver;

    @Autowired
    public ProcessTransformationService(WorkflowAutomationDriver workflowAutomationDriver) {
        this.workflowAutomationDriver = workflowAutomationDriver;
    }

    public List<TransformationDTO> getProcessModels(final String format) {
        return workflowAutomationDriver.getProcessModels(format);
    }
}
