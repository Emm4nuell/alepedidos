package br.com.alepedidos.application.controller.imple;

import br.com.alepedidos.application.controller.ICategoryController;
import br.com.alepedidos.application.request.user.CategoryRequest;
import br.com.alepedidos.application.response.user.CategoryResponse;
import br.com.alepedidos.domain.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController implements ICategoryController {
    private final ICategoryService iCategoryService;
    @Override
    public CategoryResponse create(CategoryRequest request) {
        return iCategoryService.createCategory(request);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return iCategoryService.findAll();
    }
}
