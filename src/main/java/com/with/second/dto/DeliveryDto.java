package com.with.second.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class DeliveryDto {

    private Long dno;

    private Long ono; //Order ono

    private Long oname; //Order name

    private String status;

}
