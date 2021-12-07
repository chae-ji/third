package scnu.bookstore.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {

    private Long ono;

    private String memberId;

    private Long bno;

    private Long dno;

    private LocalDateTime orderDate;
}
