package hello.third.service;

import hello.third.dto.BookDto;
import hello.third.entity.BookEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    void register(BookDto dto);

    List<BookDto> getList();

    BookDto read(Long bno);

    BookEntity update(BookDto dto);

    void remove(Long bno);

    default BookEntity dtoToEntity(BookDto dto) {
        BookEntity entity = BookEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();

        return entity;
    }

    default BookDto entityToDto(BookEntity entity) {
        BookDto dto = BookDto.builder()
                .bno(entity.getBno())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();

        return dto;
    }
}
