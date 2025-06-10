package com.bank.kairos.service;

import com.bank.kairos.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {
    DocumentDTO save(DocumentDTO documentDTO);
    DocumentDTO getById(Long id);
    List<DocumentDTO> getAll();
    List<DocumentDTO> getFilteredBy(String status, String cif);
    void deleteById(Long id);
}
