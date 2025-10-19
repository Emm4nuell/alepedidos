package br.com.alepedidos.infrastructure.repository;

import br.com.alepedidos.domain.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

    boolean existsByCategory(String category);
}
