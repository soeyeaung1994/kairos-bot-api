package com.bank.kairos.controller;

import com.bank.kairos.dto.DocumentDTO;
import com.bank.kairos.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;
    private static final String STORAGE_DIR = "uploads";
    private static final long MAX_FILE_SIZE = 300 * 1024 * 1024; // 300MB

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<?> uploadDocuments(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("docType") String documentType,
            @RequestParam("bookingCenter") String bookingCenter,
            @RequestParam("cif") String cif) {

        try {
            List<String> downloadLinks = new ArrayList<>();

            for (MultipartFile file : files) {
                if (file.getSize() > MAX_FILE_SIZE) {
                    return ResponseEntity.badRequest().body("File is too large: " + file.getOriginalFilename());
                }

                String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
                String baseName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
                String extension = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
                String uniqueFileName = String.format("%s_%d.%s", baseName, System.currentTimeMillis(), extension);

                Path storagePath = Paths.get(STORAGE_DIR).resolve(uniqueFileName);
                Files.createDirectories(storagePath.getParent());
                Files.write(storagePath, file.getBytes());

                DocumentDTO documentDTO = DocumentDTO.builder()
                        .fileName(originalFilename)
                        .contentType(file.getContentType())
                        .content(file.getBytes())
                        .documentType(documentType)
                        .bookingCenter(bookingCenter)
                        .cif(cif)
                        .build();

                DocumentDTO savedDocument = documentService.save(documentDTO);
                downloadLinks.add("http://localhost:8080/api/documents/files/" + uniqueFileName);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Received the following file(s) successfully! ✅");
            response.put("downloadLinks", downloadLinks);
            return ResponseEntity.ok(response);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sorry! Failed to read file content.");
        }
    }

    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        Path filePath = Paths.get(STORAGE_DIR).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(filePath);
        MediaType mediaType = contentType != null ? MediaType.valueOf(contentType) : MediaType.APPLICATION_OCTET_STREAM;

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + URLEncoder.encode(fileName, StandardCharsets.UTF_8) + "\"")
                .body(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(documentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getAllDocuments(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String cif) {
        return ResponseEntity.ok(documentService.getFilteredBy(status, cif));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocumentById(@PathVariable("id") Long id) {
        documentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
