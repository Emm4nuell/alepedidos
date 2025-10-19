package br.com.alepedidos.application.controller;


import br.com.alepedidos.application.request.user.CategoryRequest;
import br.com.alepedidos.application.response.user.CategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface ICategoryController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-category")
    CategoryResponse create(@RequestBody @Valid CategoryRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categorys")
    List<CategoryResponse> findAll();

}
