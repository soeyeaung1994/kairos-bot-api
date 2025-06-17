package com.bank.kairos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 5:03 pm
 */
@Entity
@Table(name = "document_type_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeMetadata {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    private String questionKey;
    private String questionLabel;
}
