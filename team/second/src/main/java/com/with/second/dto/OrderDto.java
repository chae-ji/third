package com.with.second.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDto {

    private Long ono;

    private LocalDateTime orderDate;

    private Long bno;    //Book bno

<<<<<<< HEAD
    private String bookName;   //Book name

=======
    private String bookName;    //Book name

    private Long ino;   //Book_Img ino

>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
    private String userId;  //Member id

    private String status;
}
