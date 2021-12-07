package scnu.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scnu.bookstore.entity.CategoryEntity;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
