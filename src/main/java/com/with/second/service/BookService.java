package com.with.second.service;

import com.with.second.dto.BookDto;
import com.with.second.entity.BookEntity;

import java.util.List;

public interface BookService {

    public void register(BookDto dto);

    public List<BookDto> getList();

    public BookDto read(Long bno);

    default BookEntity dtoToEntity(BookDto dto){
        BookEntity entity = BookEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .department(dto.getDepartment())
                .isNew(dto.isNew())
                .status(dto.getStatus())
                .build();

        return entity;
    }

    default BookDto entityToDto(BookEntity entity){
        BookDto dto = BookDto.builder()
                .bno(entity.getBno())
                .name(entity.getName())
                .price(entity.getPrice())
                .department(entity.getDepartment())
                .isNew(entity.isNew())
                .status(entity.getStatus())
                .regDate(entity.getModDate())
                .build();

        return dto;
    }
}
