package scnu.bookstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Book_ImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String iname;

    private String uuid;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity bookEntity;
}