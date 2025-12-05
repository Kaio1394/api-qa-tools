package br.com.api.qa.tools.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.qa.tools.domain.model.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, UUID> {

}
