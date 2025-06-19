package com.bank.kairos.mapper;

import com.bank.kairos.dto.DocumentTypeDTO;
import com.bank.kairos.dto.DocumentTypeMetadataDTO;
import com.bank.kairos.entity.DocumentType;
import com.bank.kairos.entity.DocumentTypeMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {
    DocumentTypeMapper INSTANCE = Mappers.getMapper(DocumentTypeMapper.class);

    DocumentTypeDTO toDto(DocumentType entity);
    List<DocumentTypeDTO> toDtoList(List<DocumentType> entities);

    DocumentTypeMetadataDTO toDto(DocumentTypeMetadata entity);
}
