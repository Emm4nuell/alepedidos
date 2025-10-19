package br.com.alepedidos.domain.service;

import br.com.alepedidos.application.request.user.CategoryRequest;
import br.com.alepedidos.application.response.user.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    List<CategoryResponse> findAll();
}
