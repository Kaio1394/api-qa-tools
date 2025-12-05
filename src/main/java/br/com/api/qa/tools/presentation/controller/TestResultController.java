package br.com.api.qa.tools.presentation.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.qa.tools.application.service.TestResultService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class TestResultController {
    private final TestResultService service;

    public TestResultController(TestResultService service) {
        this.service = service;
    }

    @GetMapping("upload/results")
    public String getMethodName() {
        log.info("Chamado o endpoint do método: getMethodName");
        return new String("Hello");
    }
}
