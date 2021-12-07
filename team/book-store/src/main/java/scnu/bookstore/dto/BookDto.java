package scnu.bookstore.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {

    private Long bno;

    private String college;

    private String department;

    private String bookName;    // 책 이름

    private int price;  // 가격

    private boolean isNew;  // 중고 여부

    private LocalDateTime regDate;
}
