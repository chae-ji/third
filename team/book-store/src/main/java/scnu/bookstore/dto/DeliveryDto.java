package scnu.bookstore.dto;


import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeliveryDto {

    private Long dno;

    private String status;
}
