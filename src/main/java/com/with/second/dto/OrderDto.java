package com.with.second.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class OrderDto {

    private Long ono;

    private LocalDateTime orderDate;

    private Long bno;   //Book bno

    private String name;   //Book name

    private String id;  //Member id
}
