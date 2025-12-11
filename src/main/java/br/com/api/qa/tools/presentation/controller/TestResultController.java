package br.com.api.qa.tools.presentation.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.qa.tools.application.DTO.TestResultRequestDto;
import br.com.api.qa.tools.application.DTO.TestResultResponseDto;
import br.com.api.qa.tools.application.interfaces.TestResultService;
import br.com.api.qa.tools.application.service.TestResultServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class TestResultController {
    @Autowired
    private TestResultService service;

    @GetMapping("results")
    public CompletableFuture<ResponseEntity<List<TestResultResponseDto>>> getResults() {
        return service.getAllResults()
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("result/{id}")
    public CompletableFuture<ResponseEntity<TestResultResponseDto>> getResultById(@PathVariable UUID id) {
        return service.getResultById(id)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("upload/result")
    public CompletableFuture<ResponseEntity<TestResultResponseDto>> postUploadResult(
            @RequestBody TestResultRequestDto entity) {
        return service.add(entity)
                .thenApply(result -> ResponseEntity.status(HttpStatus.CREATED).body(result));
    }
}
