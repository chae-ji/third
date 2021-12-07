package scnu.bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BookEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String bookName;

    private int price;

    private boolean isNew;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;
}
