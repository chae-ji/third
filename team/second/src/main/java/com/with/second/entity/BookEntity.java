package com.with.second.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
<<<<<<< HEAD
@ToString(exclude = {"book_imgEntity"})
=======
@ToString(exclude = "book_imgEntity")
>>>>>>> 39920db7332b085d01dc02ff6f688e8978e12708
public class BookEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String name;

    private int price;

    private String department;

    private boolean isNew;

    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    private Book_ImgEntity book_imgEntity;
}
