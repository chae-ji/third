package hello.third.entity;

import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Entity
public class Book_imgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String name;

    private String url;

    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity book;

}
