package com.bank.kairos.service.impl;

import com.bank.kairos.repository.DocumentTypeMetadataRepository;
import com.bank.kairos.service.MetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:31 pm
 */
@Service
@RequiredArgsConstructor
public class MetadataServiceImpl implements MetadataService {

    private final DocumentTypeMetadataRepository metadataRepository;

    @Override
    public List<Map<String, String>> getQuestionsByDocTypeId(Long docTypeId) {
        return metadataRepository.findByDocumentTypeId(docTypeId).stream()
                .map(m -> Map.of("key", m.getQuestionKey(), "label", m.getQuestionLabel()))
                .toList();
    }
}
