package br.com.api.qa.tools.application.interfaces;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface BaseService<CreateDto, ResponseDto> {
    CompletableFuture<List<ResponseDto>> getAllResults();

    CompletableFuture<ResponseDto> getResultById(UUID id);

    CompletableFuture<CreateDto> add(CreateDto createRequest);
}
