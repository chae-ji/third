package scnu.bookstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scnu.bookstore.dto.CategoryDto;
import scnu.bookstore.entity.CategoryEntity;
import scnu.bookstore.repository.CategoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void register() {

        CategoryDto dto = CategoryDto.builder()
                .categoryName("전기공학과")
                .college("공과대학")
                .build();

        categoryService.register(dto);
    }

    @Test
    void getList() {

        List<CategoryDto> result = categoryService.getList();
        result.stream().forEach(category -> System.out.println(category));
    }

    @Test
    void remove() {
        categoryService.remove(2L);
    }
}