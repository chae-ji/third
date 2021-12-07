package scnu.bookstore.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BucketDto {

    private Long sno;

    private Long bno;

    private String memberId;
}
