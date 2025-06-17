package com.bank.kairos.dto;

import com.bank.kairos.entity.Workflow;
import com.bank.kairos.entity.WorkflowMetadata;
import lombok.*;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:56 pm
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowDTO {
    private String workflowId;
    private String userId;
    private String tenant;
    private String documentType;
    private String status;
    private Map<String, String> metadata;

    public WorkflowDTO(Workflow wf) {
        this.workflowId = wf.getWorkflowId();
        this.userId = wf.getUserId();
        this.tenant = wf.getTenant();
        this.documentType = wf.getDocumentType();
        this.status = wf.getStatus();
        this.metadata = wf.getMetadata().stream()
                .collect(Collectors.toMap(WorkflowMetadata::getMetadataKey, WorkflowMetadata::getMetadataValue));
    }
}
