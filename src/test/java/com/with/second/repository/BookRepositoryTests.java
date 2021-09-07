package com.with.second.repository;


import com.with.second.dto.BookDto;
import com.with.second.entity.BookEntity;
import com.with.second.entity.Book_ImgEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void save(){
        IntStream.rangeClosed(1,100).forEach(i -> {


            if(i < 25){
                BookEntity entity = BookEntity.builder()
                        .name("book..." + i)
                        .price(10000)
                        .department("컴퓨터공학과")
                        .isNew(false)
                        .status("하")
                        .build();
                bookRepository.save(entity);
            }
            else if(i <= 50){
                BookEntity entity = BookEntity.builder()
                        .name("book..." + i)
                        .price(10000)
                        .department("컴퓨터공학과")
                        .isNew(false)
                        .status("중")
                        .build();
                bookRepository.save(entity);
            }
            else if(i <= 75){
                BookEntity entity = BookEntity.builder()
                        .name("book..." + i)
                        .price(10000)
                        .department("컴퓨터공학과")
                        .isNew(false)
                        .status("상")
                        .build();
                bookRepository.save(entity);
            }
            else{
                BookEntity entity = BookEntity.builder()
                        .name("book..." + i)
                        .price(10000)
                        .department("컴퓨터공학과")
                        .isNew(true)
                        .status("신간")
                        .build();
                bookRepository.save(entity);
            }
        });
    }

    @Test
    public void remove(){
        bookRepository.deleteById(10L);
    }

}
