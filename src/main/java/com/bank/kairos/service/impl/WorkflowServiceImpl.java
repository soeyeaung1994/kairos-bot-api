package com.bank.kairos.service.impl;

import com.bank.kairos.dto.User;
import com.bank.kairos.dto.WorkflowDTO;
import com.bank.kairos.entity.Workflow;
import com.bank.kairos.entity.WorkflowMetadata;
import com.bank.kairos.mapper.WorkflowMapper;
import com.bank.kairos.repository.WorkflowRepository;
import com.bank.kairos.service.WorkflowService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 6:46 pm
 */
@Service
@RequiredArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {
    private final WorkflowRepository workflowRepository;
    private final WorkflowMapper mapper;

    public String generateWorkflowId(String userId) {
        return "WRKFLW_" + userId + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
    }

    @Override
    public WorkflowDTO createWorkflow(User user, String docType, Map<String, String> metadataMap) {
        String id = generateWorkflowId(user.getUsername());
        Workflow wf = new Workflow(id, user.getUsername(), user.getSelectedTenant(), docType, "SUBMITTED");
        List<WorkflowMetadata> metadataList = metadataMap.entrySet().stream()
                .map(e -> new WorkflowMetadata(wf, e.getKey(), e.getValue()))
                .toList();
        wf.setMetadata(metadataList);
        Workflow workflow = workflowRepository.save(wf);
        return mapper.toDto(workflow);
    }

    @Override
    public Optional<WorkflowDTO> getWorkflow(String workflowId) {
        Optional<Workflow> workflow = workflowRepository.findByWorkflowId(workflowId);
        return mapper.toOptionalDto(workflow);
    }

    @Override
    public Page<WorkflowDTO> searchPaginated(int page, int size, String tenant, String docType, String userId) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Workflow> workflowPage = workflowRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (tenant != null) predicates.add(cb.equal(root.get("tenant"), tenant));
            if (docType != null) predicates.add(cb.equal(root.get("documentType"), docType));
            if (userId != null) predicates.add(cb.equal(root.get("userId"), userId));
            return cb.and(predicates.toArray(new Predicate[0]));
        }, pageable);
        return mapper.toPageDto(workflowPage);
    }
}
