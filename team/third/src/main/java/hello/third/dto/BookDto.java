package hello.third.dto;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long bno;

    private String name;

    private int price;
}
