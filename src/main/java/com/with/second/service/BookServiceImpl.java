package com.with.second.service;

import com.with.second.dto.BookDto;
import com.with.second.entity.BookEntity;
import com.with.second.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    // 책 등록
    @Override
    public void register(BookDto dto) {

        log.info("register...");

        BookEntity entity = dtoToEntity(dto);

        bookRepository.save(entity);

        log.info("complete register...");
    }

    // 전체 책 페이지
    @Override
    public List<BookDto> getList() {

        log.info("getList...");

        List<BookEntity> bookEntitys = bookRepository.findAll(Sort.by("bno").descending());
        List<BookDto> bookDtos = new ArrayList<>();

        for(BookEntity entity : bookEntitys){
            bookDtos.add(entityToDto(entity));
        }

        return bookDtos;
    }

    // 책 상세 페이지
    @Override
    public BookDto read(Long bno) {

        log.info("read...");

        Optional<BookEntity> result = bookRepository.findById(bno);

        BookEntity entity = result.get();

        BookDto dto = entityToDto(entity);

        return dto;
    }


}
