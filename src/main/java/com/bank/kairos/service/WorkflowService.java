package com.bank.kairos.service;

import com.bank.kairos.dto.User;
import com.bank.kairos.dto.WorkflowDTO;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:47 pm
 */
public interface WorkflowService {

    WorkflowDTO createWorkflow(User user, String docType, Map<String, String> metadataMap);
    Optional<WorkflowDTO> getWorkflow(String workflowId);
    Page<WorkflowDTO> searchPaginated(int page, int size, String tenant, String docType, String userId);
}
