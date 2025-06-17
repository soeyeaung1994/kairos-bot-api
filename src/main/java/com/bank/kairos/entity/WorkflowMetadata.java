package com.bank.kairos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:43 pm
 */
@Entity
@Table(name = "workflow_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowMetadata {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

    @Column(name = "metadata_key")
    private String metadataKey;

    @Column(name = "metadata_value")
    private String metadataValue;

    public WorkflowMetadata(Workflow workflow, String metadataKey, String metadataValue) {
        this.workflow = workflow;
        this.metadataKey = metadataKey;
        this.metadataValue = metadataValue;
    }
}
