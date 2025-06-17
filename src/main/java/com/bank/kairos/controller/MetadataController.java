package com.bank.kairos.controller;

import com.bank.kairos.service.MetadataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 4:29 pm
 */

@RestController
@RequestMapping("/metadata")
public class MetadataController {
    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping("/questions")
    public List<Map<String, String>> getQuestions(@RequestParam Long docTypeId) {
        return metadataService.getQuestionsByDocTypeId(docTypeId);
    }
}
