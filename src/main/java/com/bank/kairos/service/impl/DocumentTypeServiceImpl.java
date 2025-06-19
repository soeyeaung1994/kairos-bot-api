package com.bank.kairos.service.impl;

import com.bank.kairos.dto.DocumentTypeDTO;
import com.bank.kairos.entity.DocumentType;
import com.bank.kairos.mapper.DocumentTypeMapper;
import com.bank.kairos.repository.DocumentTypeRepository;
import com.bank.kairos.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:28 pm
 */
@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final DocumentTypeRepository documentTypeRepository;
    private final DocumentTypeMapper mapper;

    @Override
    public List<DocumentTypeDTO> getDocumentTypesForTenant(String tenant) {
        List<DocumentType> entities = documentTypeRepository.findByTenant(tenant);
        return mapper.toDtoList(entities);
    }
}
