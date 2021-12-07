package hello.third.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Book_imgDto {

    private String name;

    private String uuid;

    private String url;
}
