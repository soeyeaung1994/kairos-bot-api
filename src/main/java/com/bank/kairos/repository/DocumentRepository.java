package com.bank.kairos.repository;

import com.bank.kairos.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}
