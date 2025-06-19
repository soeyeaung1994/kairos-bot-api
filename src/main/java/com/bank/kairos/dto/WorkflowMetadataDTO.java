package com.bank.kairos.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Soe Ye Aung
 * @Date: 18/6/25
 * @Time: 5:35 pm
 */
@Getter
@Setter
public class WorkflowMetadataDTO {
    private Long id;
    private String metadataKey;
    private String metadataValue;
}
