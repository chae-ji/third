package com.with.second.service;

import com.with.second.dto.BookDto;
import com.with.second.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.with.second.dto.OrderDto;

import java.util.stream.IntStream;

@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private OrderService service;

    @Test
    public void register() {

        IntStream.rangeClosed(1,100).forEach(i ->{

            BookDto bookdto = BookDto.builder()
                    .bno((long) i)
                    .name("채지웅.." + i)
                    .build();

            MemberDto memberDto = MemberDto.builder()
                    .id("hello1")
                    .build();

            OrderDto dto = OrderDto.builder()
                    .status("상품준비중")
                    .bno(bookdto.getBno())
                    .bookName(bookdto.getName())
                    .userId(memberDto.getId())
                    .build();

            service.register(dto);
        });
   }
}