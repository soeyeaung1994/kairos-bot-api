package com.bank.kairos.service.impl;

import com.bank.kairos.entity.DocumentType;
import com.bank.kairos.entity.User;
import com.bank.kairos.repository.DocumentTypeRepository;
import com.bank.kairos.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:28 pm
 */
@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public List<DocumentType> getDocumentTypesForTenant(String tenant) {
        return documentTypeRepository.findByTenant(tenant);
    }
}
