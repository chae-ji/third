package com.with.second.service;


import com.with.second.dto.BucketDto;
import com.with.second.entity.BookEntity;
import com.with.second.entity.BucketEntity;
import com.with.second.entity.MemberEntity;


import java.util.List;


public interface BucketService {

    void register(BucketDto dto);

    List<BucketDto> getList(String id);

    void remove(Long sno);


    default BucketEntity dtoToEntity(BucketDto dto) {

        BookEntity bookEntity = BookEntity.builder()
                .name(dto.getName())
                .bno(dto.getBno())
                .price(dto.getPrice())
                .build();

        MemberEntity memberEntity = MemberEntity.builder()
                .id(dto.getId())
                .build();

        BucketEntity bucketEntity = BucketEntity.builder()
                .bookEntity(bookEntity)
                .memberEntity(memberEntity)
                .build();

        return bucketEntity;
    }

    default BucketDto entityToDto(BucketEntity bucketEntity, String name) {


        BucketDto dto = BucketDto.builder()
                .sno(bucketEntity.getSno())
                .bno(bucketEntity.getBookEntity().getBno())
                .name(name)
                .price(bucketEntity.getBookEntity().getPrice())
                .id(bucketEntity.getMemberEntity().getId())
                .build();



        return dto;
    }


}
