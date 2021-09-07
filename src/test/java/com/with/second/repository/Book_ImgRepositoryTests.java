package com.with.second.repository;


import com.with.second.entity.BookEntity;
import com.with.second.entity.Book_ImgEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class Book_ImgRepositoryTests {

    @Autowired
    private Book_ImgRepository book_imgRepository;

    @Test
    public void save(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            BookEntity bookEntity = BookEntity.builder()
                    .bno((long) i)
                    .build();

            Book_ImgEntity entity = Book_ImgEntity.builder()
                    .iname("img..." + i)
                    .uuid("uuid..." + i)
                    .bookEntity(bookEntity)
                    .build();

            book_imgRepository.save(entity);
        });

    }

    @Test
    public void read() {

        List<Book_ImgEntity> result = book_imgRepository.findAll();
        for(Book_ImgEntity entity : result){
            System.out.println(entity);
        };

    }

    @Test
    public void read2(){

        Optional<Book_ImgEntity> result = book_imgRepository.findById(30L);
        Book_ImgEntity entity = result.get();
        System.out.println(entity);
    }
}
