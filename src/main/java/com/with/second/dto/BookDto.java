package com.with.second.dto;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {

    private Long bno;

    private String name;

    private int price;

    private String department;

    private boolean isNew;

    private String status;

    private LocalDateTime regDate;

}
