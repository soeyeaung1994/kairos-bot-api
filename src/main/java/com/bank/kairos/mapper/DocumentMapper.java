package com.bank.kairos.mapper;

import com.bank.kairos.dto.DocumentDTO;
import com.bank.kairos.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);
    DocumentDTO toDto(DocumentEntity documentEntity);
    DocumentEntity toEntity(DocumentDTO documentDTO);
}
