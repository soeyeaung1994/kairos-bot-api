package com.bank.kairos.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@Entity
@Table(name = "documents")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private String bookingCenter;

    @Column(nullable = false)
    private String cif;

    @Column(nullable = false)
    private String contentType;

    @Lob
    @Column(nullable = false)
    private byte[] content;

    @Column(nullable = false)
    private String status; // e.g., RECEIVED, PROCESSING, COMPLETE, FAILED

    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdDate;

    private String updatedBy;

    @LastModifiedDate
    private Instant updatedDate;
}
