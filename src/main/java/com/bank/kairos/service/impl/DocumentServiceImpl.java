package com.bank.kairos.service.impl;

import com.bank.kairos.dto.DocumentDTO;
import com.bank.kairos.entity.Document;
import com.bank.kairos.mapper.DocumentMapper;
import com.bank.kairos.repository.DocumentRepository;
import com.bank.kairos.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Override
    public DocumentDTO save(DocumentDTO documentDTO) {
        Document entity = documentMapper.toEntity(documentDTO);
        entity.setStatus("RECEIVED");
        return documentMapper.toDto(documentRepository.save(entity));
    }

    @Override
    public DocumentDTO getById(Long id) {
        return documentRepository.findById(id)
                .map(documentMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Could not find document with id: " + id));
    }

    @Override
    public List<DocumentDTO> getAll() {
        return documentRepository.findAll().stream()
                .map(documentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentDTO> getFilteredBy(String status, String cif) {
        return documentRepository.findAll().stream()
                .filter(doc -> (status == null || doc.getStatus().equalsIgnoreCase(status)) &&
                               (cif == null || doc.getCif().equalsIgnoreCase(cif)))
                .map(documentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }
}
