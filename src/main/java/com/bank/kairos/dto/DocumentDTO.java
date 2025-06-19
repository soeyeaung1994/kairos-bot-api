package com.bank.kairos.dto;

import lombok.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDTO {
    private Long id;
    private String fileName;
    private String documentType;
    private String bookingCenter;
    private String cif;
    private String contentType;
    private byte[] content;
    private String status;
    private String createdBy;
    private Instant createdDate;
    private String updatedBy;
    private Instant updatedDate;
}
