package br.com.api.qa.tools.presentation.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.qa.tools.application.DTO.TestResultRequestDto;
import br.com.api.qa.tools.application.DTO.TestResultResponseDto;
import br.com.api.qa.tools.application.service.TestResultServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class TestResultController {
    private final TestResultServiceImpl service;

    public TestResultController(TestResultServiceImpl service) {
        this.service = service;
    }

    @GetMapping("results")
    public CompletableFuture<List<TestResultResponseDto>> getResults() {
        return service.getAllResults();
    }

    @PostMapping("upload/result")
    public CompletableFuture<TestResultRequestDto> postUploadResult(@RequestBody TestResultRequestDto entity) {
        return service.add(entity);
    }
}
