package com.with.second.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class MemberDto {

    private String id;

    private String password;

    private String name;

    private String department;
}
