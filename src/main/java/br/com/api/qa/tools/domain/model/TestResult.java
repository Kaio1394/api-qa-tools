package br.com.api.qa.tools.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import br.com.api.qa.tools.domain.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "test_results")
@Data
public class TestResult {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "tags")
    private String tags;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private Status status;

    @Column(name = "execution_date")
    private LocalDateTime executionDate;
}
