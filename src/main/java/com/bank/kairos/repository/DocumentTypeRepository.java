package com.bank.kairos.repository;

import com.bank.kairos.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:19 pm
 */
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    List<DocumentType> findByTenant(String tenant);
}
