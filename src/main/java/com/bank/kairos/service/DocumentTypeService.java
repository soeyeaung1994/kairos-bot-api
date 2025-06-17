package com.bank.kairos.service;

import com.bank.kairos.entity.DocumentType;
import com.bank.kairos.entity.User;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:29 pm
 */
public interface DocumentTypeService {
    List<DocumentType> getDocumentTypesForTenant(String tenant);
}
