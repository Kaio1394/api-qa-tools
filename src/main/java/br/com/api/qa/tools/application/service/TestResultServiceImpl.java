package br.com.api.qa.tools.application.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final TestResultRepository repository;

    public TestResultServiceImpl(TestResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<TestResultRequestDto> add(TestResultRequestDto createRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Add'");
    }

    @Override
    public CompletableFuture<List<TestResultResponseDto>> getAllResults() {
        return CompletableFuture.supplyAsync(() -> {
            List<TestResult> listModel = repository.findAll();

            return listModel.stream()
                    .map(item -> mapper.map(item, TestResultResponseDto.class))
                    .toList();
        });
    }

    @Override
    public CompletableFuture<TestResultResponseDto> getResultById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultById'");
    }
}
