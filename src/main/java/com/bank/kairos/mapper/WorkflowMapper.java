package com.bank.kairos.mapper;

import com.bank.kairos.dto.WorkflowDTO;
import com.bank.kairos.dto.WorkflowMetadataDTO;
import com.bank.kairos.entity.Workflow;
import com.bank.kairos.entity.WorkflowMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:39 pm
 */
@Mapper(componentModel = "spring")
public interface WorkflowMapper {
    WorkflowMapper INSTANCE = Mappers.getMapper(WorkflowMapper.class);

    WorkflowDTO toDto(Workflow entity);
    List<WorkflowDTO> toDtoList(List<Workflow> entities);
    WorkflowMetadataDTO toDto(WorkflowMetadata entity);
    default Page<WorkflowDTO>  toPageDto(Page<Workflow> workflowPage) {
        return new PageImpl<>(toDtoList(workflowPage.getContent()), workflowPage.getPageable(), workflowPage.getTotalElements());
    };
    default Optional<WorkflowDTO> toOptionalDto(Optional<Workflow> entity) {
        return entity.map(this::toDto);
    }
}

