package com.bank.kairos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:43 pm
 */
@Entity
@Table(name = "workflow")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workflow {
    @Id
    private String workflowId;
    private String userId;
    private String tenant;
    private String documentType;
    private String status;

    @OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkflowMetadata> metadata;

    public Workflow(String id, String userId, String tenant, String documentType, String status) {
        this.workflowId = id;
        this.userId = userId;
        this.tenant = tenant;
        this.documentType = documentType;
        this.status = status;
    }
}
