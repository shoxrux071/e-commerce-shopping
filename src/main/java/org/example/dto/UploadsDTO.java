package org.example.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadsDTO {
    private Long id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private String path;
    private long size;
}
