package scnu.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scnu.bookstore.dto.CategoryDto;
import scnu.bookstore.entity.CategoryEntity;
import scnu.bookstore.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void register(CategoryDto dto) {

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .categoryName(dto.getCategoryName())
                .college(dto.getCollege())
                .build();

        categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryDto> getList() {

        List<CategoryEntity> entities = categoryRepository.findAll();

        List<CategoryDto> dtos = new ArrayList<>();

        entities.stream().forEach(entity ->{
            CategoryDto dto = CategoryDto.builder()
                    .cno(entity.getCno())
                    .categoryName(entity.getCategoryName())
                    .college(entity.getCollege())
                    .build();

            dtos.add(dto);
        });

        return dtos;
    }

    @Transactional
    @Override
    public void remove(Long cno) {

        categoryRepository.deleteById(cno);

    }
}
