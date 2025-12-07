package br.com.api.qa.tools.application.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.api.qa.tools.domain.enums.Status;
import lombok.Data;

@Data
public class TestResultResponseDto {
    private UUID id;
    private String ticket;
    private String tags;
    private Status status;
    private LocalDateTime executionDate;
}
