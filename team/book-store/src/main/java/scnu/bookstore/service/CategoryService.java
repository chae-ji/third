package scnu.bookstore.service;


import scnu.bookstore.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    void register(CategoryDto dto);

    List<CategoryDto> getList();

    void remove(Long cno);
}
