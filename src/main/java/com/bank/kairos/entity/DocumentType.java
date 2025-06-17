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
 * @Time: 6:18 pm
 */

@Entity
@Table(name = "document_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType {
    @Id
    private Long id;
    private String name;
    private String tenant;

    @OneToMany(mappedBy = "documentType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentTypeMetadata> metadataList;
}
