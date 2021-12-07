package hello.third.controller;

import hello.third.dto.BookDto;
import hello.third.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/book")

@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/register")
    public HttpStatus register(@RequestBody BookDto dto) {

        log.info("----- register -----");

        bookService.register(dto);

        return HttpStatus.OK;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDto>> getList() {

        log.info("----- get List -----");

        List<BookDto> bookDtos = bookService.getList();

        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }

    @GetMapping("/read/{bno}")
    public ResponseEntity<BookDto> read(@PathVariable Long bno) {

        log.info("----- " + bno + " read -----");

        BookDto dto = bookService.read(bno);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public HttpStatus update(@RequestBody BookDto dto) {

        log.info("----- update -----");

        bookService.update(dto);

        return HttpStatus.OK;
    }

    @PostMapping("/remove/{bno}")
    public HttpStatus remove(@PathVariable Long bno) {

        log.info("----- " + bno + " remove -----");

        bookService.remove(bno);

        return HttpStatus.OK;
    }
}
