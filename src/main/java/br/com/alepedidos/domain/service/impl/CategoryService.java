package br.com.alepedidos.domain.service.impl;

import br.com.alepedidos.application.request.user.CategoryRequest;
import br.com.alepedidos.application.response.user.CategoryResponse;
import br.com.alepedidos.domain.model.CategoryModel;
import br.com.alepedidos.domain.service.ICategoryService;
import br.com.alepedidos.infrastructure.repository.CategoryRepository;
import br.com.alepedidos.utils.GenericMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final GenericMapper mapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        if (categoryRepository.existsByCategory(request.category())) {
            throw new NullPointerException("Categoria já cadastrada na base de dados.");
        }
        var category = categoryRepository.save(mapper.map(request,
                CategoryModel.class));
        return mapper.map(category,
                CategoryResponse.class);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return mapper.mapAll(categoryRepository.findAll(),
                CategoryResponse.class);
    }
}
