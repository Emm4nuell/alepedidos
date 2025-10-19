package br.com.alepedidos.application.controller.imple;

import br.com.alepedidos.application.controller.IProductController;
import br.com.alepedidos.application.request.product.ProductRequest;
import br.com.alepedidos.application.response.product.ProductResponse;
import br.com.alepedidos.domain.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductController implements IProductController {
    private final IProductService productService;
    @Override
    public ProductResponse createProduct(ProductRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> findAllProduct() {
        return List.of();
    }

    @Override
    public ProductResponse findByIdProduct(UUID id) {
        return null;
    }
}
