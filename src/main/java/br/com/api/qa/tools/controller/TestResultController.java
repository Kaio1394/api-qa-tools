package br.com.api.qa.tools.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1")
public class TestResultController {
    @GetMapping("upload/results")
    public String getMethodName() {
        return new String("Hello");
    }
}
