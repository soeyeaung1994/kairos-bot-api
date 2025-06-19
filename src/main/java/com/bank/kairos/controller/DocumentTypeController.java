package com.bank.kairos.controller;

import com.bank.kairos.dto.DocumentTypeDTO;
import com.bank.kairos.service.DocumentTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 4:42 pm
 */
@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @GetMapping
    public List<DocumentTypeDTO> getByTenant(@RequestParam String tenant) {
        return documentTypeService.getDocumentTypesForTenant(tenant);
    }
}
