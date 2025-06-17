package com.bank.kairos.controller;

import com.bank.kairos.entity.DocumentType;
import com.bank.kairos.entity.User;
import com.bank.kairos.service.DocumentTypeService;
import jakarta.servlet.http.HttpServletRequest;
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
@RequestMapping("/document-types")
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @GetMapping
    public List<DocumentType> getByTenant(@RequestParam String tenant) {
        return documentTypeService.getDocumentTypesForTenant(tenant);
    }
}
