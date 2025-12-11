package br.com.api.qa.tools.application.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.api.qa.tools.application.DTO.TestResultRequestDto;
import br.com.api.qa.tools.application.DTO.TestResultResponseDto;
import br.com.api.qa.tools.application.interfaces.TestResultService;
import br.com.api.qa.tools.domain.model.TestResult;
import br.com.api.qa.tools.infrastructure.repository.TestResultRepository;

@Service
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TestResultRepository repository;

    @Override
    public CompletableFuture<TestResultResponseDto> add(TestResultRequestDto createRequest) {
        return CompletableFuture.supplyAsync(() -> {
            TestResult entity = mapper.map(createRequest, TestResult.class);
            entity = repository.save(entity);
            TestResultResponseDto dto = mapper.map(entity, TestResultResponseDto.class);
            return dto;
        });
    }

    @Async
    @Override
    public CompletableFuture<List<TestResultResponseDto>> getAllResults() {
        return CompletableFuture.supplyAsync(() -> {
            List<TestResult> listModel = repository.findAll();

            return listModel.stream()
                    .map(item -> mapper.map(item, TestResultResponseDto.class))
                    .toList();
        });
    }

    @Async
    @Override
    public CompletableFuture<TestResultResponseDto> getResultById(UUID id) {
        return CompletableFuture.supplyAsync(() -> {
            TestResult entity = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Resultado não encontrado"));
            TestResultResponseDto dto = mapper.map(entity, TestResultResponseDto.class);
            return dto;
        });
    }

    @Override
    public CompletableFuture<List<TestResultResponseDto>> findByScenarioName(String scenarioName) {
        return CompletableFuture.supplyAsync(() -> {
            List<TestResultResponseDto> listDto = repository.findByStatus(scenarioName)
                    .stream()
                    .map(e -> mapper.map(e, TestResultResponseDto.class))
                    .toList();
            return listDto;
        });
    }

    @Override
    public CompletableFuture<List<TestResultResponseDto>> findByStatus(String status) {
        return CompletableFuture.supplyAsync(() -> {
            List<TestResultResponseDto> listDto = repository.findByStatus(status)
                    .stream()
                    .map(e -> mapper.map(e, TestResultResponseDto.class))
                    .toList();
            return listDto;
        });
    }
}
