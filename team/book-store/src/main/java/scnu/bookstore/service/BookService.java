package scnu.bookstore.service;

import org.springframework.web.multipart.MultipartFile;
import scnu.bookstore.dto.BookDto;
import scnu.bookstore.entity.BookEntity;
import scnu.bookstore.entity.CategoryEntity;

import java.util.List;

public interface BookService {

    public Long register(MultipartFile[] files, String uploadPath, BookDto dto);

    public List<BookDto> getList();

    public BookDto read(Long bno);

    public Long update(BookDto dto);

    public void remove(Long bno);


    default BookEntity dtoToEntity(BookDto dto, CategoryEntity category) {

        BookEntity bookEntity = BookEntity.builder()
                .bookName(dto.getBookName())
                .isNew(dto.isNew())
                .category(category)
                .price(dto.getPrice())
                .build();

        return bookEntity;
    }

    default BookDto entityToDto(BookEntity entity) {

        BookDto bookDto = BookDto.builder()
                .bno(entity.getBno())
                .bookName(entity.getBookName())
                .price(entity.getPrice())
                .isNew(entity.isNew())
                .department(entity.getCategory().getCategoryName())
                .college(entity.getCategory().getCollege())
                .regDate(entity.getRegdate())
                .build();

        return bookDto;
    }
}
