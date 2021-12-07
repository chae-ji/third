package hello.third.service;

import hello.third.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void register() {
        for (int i = 1; i <= 100; i++) {
            BookDto dto = BookDto.builder()
                    .name("test-" + i)
                    .price(i)
                    .build();

            bookService.register(dto);
        }
    }

    @Test
    void getList() {
        List<BookDto> list = bookService.getList();

        for (BookDto bookDto : list) {
            System.out.println(bookDto);
        }
    }

    @Test
    void read() {
        BookDto read = bookService.read(99L);
        System.out.println(read);
    }


    @Test
    void update() {
        BookDto dto = BookDto.builder()
                .bno(3L)
                .name("test33")
                .price(30000)
                .build();

        bookService.update(dto);
    }

    @Test
    void remove() {
        bookService.remove(5L);
    }



}