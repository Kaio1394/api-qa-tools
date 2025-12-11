package br.com.api.qa.tools.application.interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import br.com.api.qa.tools.application.DTO.TestResultRequestDto;
import br.com.api.qa.tools.application.DTO.TestResultResponseDto;

public interface TestResultService extends BaseService<TestResultRequestDto, TestResultResponseDto> {
    CompletableFuture<List<TestResultResponseDto>> findByScenarioName(String scenarioName);

    CompletableFuture<List<TestResultResponseDto>> findByStatus(String status);
}
