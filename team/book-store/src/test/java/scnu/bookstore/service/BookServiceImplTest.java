package scnu.bookstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scnu.bookstore.dto.BookDto;
import scnu.bookstore.entity.BookEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void register() {


    }

    @Test
    void getList() {

        List<BookDto> list = bookService.getList();
        list.stream().forEach(dto -> System.out.println("dto = " + dto));

    }

    @Test
    void read() {

        BookDto read = bookService.read(1L);
        System.out.println(read);
    }

    @Test
    void update() {

        BookDto dto = BookDto.builder()
                .price(9000)
                .bookName("바뀌나?")
                .department("전기공학과")
                .isNew(false)
                .bno(3L)
                .build();

        bookService.update(dto);
    }

    @Test
    void remove() {

        bookService.remove(1L);
    }
}