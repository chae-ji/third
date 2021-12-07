package scnu.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book_ImgDto {

    private Long ino;

    private String imgName;

    private String uuid;

    private String path;

    private Long bno;
}