package br.com.api.qa.tools.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import br.com.api.qa.tools.domain.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "test_results")
@Data
public class TestResult {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "scenario_name")
    private String scenarioName;

    @Column(name = "tags")
    private String tags;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private Status status;

    @Column(name = "message_result")
    private String messageResult;

    @Column(name = "execution_date", insertable = false, updatable = false)
    private LocalDateTime executionDate;

    @PrePersist
    public void prePersist() {
        this.executionDate = LocalDateTime.now();
    }
}
