package com.bank.kairos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DocumentTypeDTO {
    private Long id;
    private String name;
    private String tenant;
    private List<DocumentTypeMetadataDTO> metadataList;
}
