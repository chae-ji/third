package com.with.second.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString

public class Book_ImgDto {

    private Long ino;

    private String iname;

    private String uuid;

    private Long bno;   //Book bno
}
