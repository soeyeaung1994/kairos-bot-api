package com.bank.kairos.service;

import com.bank.kairos.entity.User;
import com.bank.kairos.entity.Workflow;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:47 pm
 */
public interface WorkflowService {

    Workflow createWorkflow(User user, String docType, Map<String, String> metadataMap);
    Optional<Workflow> getWorkflow(String workflowId);
    Page<Workflow> searchPaginated(int page, int size, String tenant, String docType, String userId);
}
