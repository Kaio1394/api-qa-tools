package br.com.api.qa.tools.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.qa.tools.domain.model.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, UUID> {
    @Query("SELECT t FROM TestResult t WHERE t.status = :status")
    List<TestResult> findByStatus(String status);

    @Query("SELECT t FROM TestResult t WHERE t.scenarioName = :scenarioName")
    List<TestResult> findByScenarioName(String scenarioName);
}
