package scnu.bookstore.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class CategoryDto {

    private Long cno;

    private String college;

    private String categoryName;
}
