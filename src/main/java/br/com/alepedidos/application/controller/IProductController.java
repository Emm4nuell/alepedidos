package br.com.alepedidos.application.controller;

import br.com.alepedidos.application.request.product.ProductRequest;
import br.com.alepedidos.application.response.product.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/product")
public interface IProductController {
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse createProduct(@RequestBody @Valid ProductRequest request);
    List<ProductResponse> findAllProduct();
    ProductResponse findByIdProduct(@RequestParam
            UUID id);
}
