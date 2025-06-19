package com.bank.kairos.dto;
import lombok.*;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:56 pm
 */
@Getter
@Setter
public class WorkflowDTO {
    private String workflowId;
    private String userId;
    private String tenant;
    private String documentType;
    private String status;
    private List<WorkflowMetadataDTO> metadataList;
}
