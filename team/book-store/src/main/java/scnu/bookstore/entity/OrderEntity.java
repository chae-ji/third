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
public class OrderEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ono;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity memberId;

    @OneToOne(fetch = FetchType.LAZY)
    private BookEntity bno;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeliveryEntity dno;


}
