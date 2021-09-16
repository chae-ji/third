package com.with.second.service;


import com.with.second.dto.BucketDto;
import com.with.second.entity.BookEntity;
import com.with.second.entity.BucketEntity;
import com.with.second.entity.MemberEntity;
import com.with.second.repository.BookRepository;
import com.with.second.repository.BucketRepository;
import com.with.second.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BucketServiceTests {


    @Autowired
    private BucketRepository bucketRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BucketService bucketService;

    @Test
    public void register(){

        Optional<BookEntity> bookResult = bookRepository.findById(140L);

        BookEntity bookEntity = bookResult.get();

        System.out.println("bookEntity : " + bookEntity);

        Optional<MemberEntity> memberResult = memberRepository.findById("cowldnd1");
        MemberEntity memberEntity = memberResult.get();

        System.out.println("memberEntity : " + memberEntity);


        BucketDto bucketDto = BucketDto.builder()
                .userId(memberEntity.getId())
                .bno(bookEntity.getBno())
                .bookName(bookEntity.getName())
                .price(bookEntity.getPrice())
                .build();

        System.out.println("bucketDto : " + bucketDto);

        bucketService.register(bucketDto);

    }

    @Test
    public void getList(){

        List<BucketDto> list = bucketService.getList("cowldnd1");

        System.out.println("getList : " + list);
    }

    @Test
    public void remove(){

        bucketRepository.deleteById(7L);

    }

}
