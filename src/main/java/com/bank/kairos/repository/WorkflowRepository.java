package com.bank.kairos.repository;

import com.bank.kairos.entity.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:45 pm
 */
public interface WorkflowRepository extends JpaRepository<Workflow, String>, JpaSpecificationExecutor<Workflow> {
    Optional<Workflow> findByWorkflowId(String workflowId);
}
