package scnu.bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    private String college; // 단과대학(교양)

    @Column(unique = true)
    private String categoryName;    // 학과(교양은 기타)
}
