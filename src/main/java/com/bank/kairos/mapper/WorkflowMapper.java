package com.bank.kairos.mapper;

import com.bank.kairos.dto.WorkflowDTO;
import com.bank.kairos.entity.Workflow;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:39 pm
 */
public class WorkflowMapper {
    public static WorkflowDTO toDto(Workflow wf) {
        return new WorkflowDTO(wf);
    }
}

