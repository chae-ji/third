package scnu.bookstore.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scnu.bookstore.dto.BookDto;
import scnu.bookstore.service.BookService;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Value("${scnu.book-store.upload.path}")
    private String uploadPath;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestPart("file") MultipartFile[] files, @RequestPart("dto") BookDto dto) {

        Long bno = bookService.register(files, uploadPath, dto);

        return new ResponseEntity<>(bno, HttpStatus.OK);
    }
}
