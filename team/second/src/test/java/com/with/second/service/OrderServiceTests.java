package com.with.second.service;

<<<<<<< HEAD
import com.with.second.dto.BookDto;
import com.with.second.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.with.second.dto.OrderDto;

=======
import com.with.second.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
import java.util.stream.IntStream;

@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private OrderService service;

    @Test
<<<<<<< HEAD
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
=======
    public void register(){

        IntStream.rangeClosed(1,10).forEach(i -> {
            OrderDto dto = OrderDto.builder()
                    .bno(1L)
                    .bookName("자바 ORM 표준 JPA 프로그래밍")
                    .userId("User2")
                    .status("배송중")
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
                    .build();

            service.register(dto);
        });
<<<<<<< HEAD
   }
}
=======

    }

    @Test
    public void getList(){

        List<OrderDto> list = service.getList("User2");

        for(OrderDto dto : list){

            System.out.println("dto : " + dto);
        }
    }

}
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
