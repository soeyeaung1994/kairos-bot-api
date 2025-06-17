package com.bank.kairos.repository;

import com.bank.kairos.entity.DocumentTypeMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:19 pm
 */
public interface DocumentTypeMetadataRepository extends JpaRepository<DocumentTypeMetadata, Long> {
    List<DocumentTypeMetadata> findByDocumentTypeId(Long documentTypeId);
}
