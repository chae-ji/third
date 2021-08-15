package com.with.first.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board_GraphicsDTO {

    private Long bno;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime modDate;
}
