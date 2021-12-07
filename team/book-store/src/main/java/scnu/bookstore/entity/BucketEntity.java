package scnu.bookstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BucketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    @OneToOne(fetch = FetchType.LAZY)
    private BookEntity bno;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity memberId;
}
