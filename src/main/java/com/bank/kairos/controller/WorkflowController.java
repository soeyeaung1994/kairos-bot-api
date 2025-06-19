package com.bank.kairos.controller;

import com.bank.kairos.dto.WorkflowDTO;
import com.bank.kairos.dto.User;
import com.bank.kairos.service.WorkflowService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 4:28 pm
 */

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {
    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping("/create")
    public WorkflowDTO createWorkflow(@RequestBody Map<String, Object> requestBody,
                                      HttpServletRequest request) {
        User user = (User) request.getAttribute("authenticatedUser");
        String docType = (String) requestBody.get("documentType");
        Map<String, String> metadata = (Map<String, String>) requestBody.get("metadata");
        return workflowService.createWorkflow(user, docType, metadata);
    }

    @PostMapping("/track")
    public ResponseEntity<?> trackWorkflow(@RequestBody Map<String, String> requestBody) {
        String workflowId = requestBody.get("workflowId");
        Optional<WorkflowDTO> optionalWorkflow = workflowService.getWorkflow(workflowId);

        if (optionalWorkflow.isPresent()) {
            WorkflowDTO dto = optionalWorkflow.get();
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workflow not found");
        }
    }

    @GetMapping("/list")
    public Page<WorkflowDTO> listAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(required = false) String tenant,
                                     @RequestParam(required = false) String documentType,
                                     @RequestParam(required = false) String userId) {
        return workflowService.searchPaginated(page, size, tenant, documentType, userId);
    }
}
