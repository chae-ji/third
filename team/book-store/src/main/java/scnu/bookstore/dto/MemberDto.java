package scnu.bookstore.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {

    private String memberId;

    private String memberName;

    private String password;

    private String department;
}
