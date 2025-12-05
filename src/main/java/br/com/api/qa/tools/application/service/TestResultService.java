package br.com.api.qa.tools.application.service;

import org.springframework.stereotype.Service;

import br.com.api.qa.tools.infrastructure.repository.TestResultRepository;

@Service
public class TestResultService {
    private final TestResultRepository repository;

    public TestResultService(TestResultRepository repository) {
        this.repository = repository;
    }
}
