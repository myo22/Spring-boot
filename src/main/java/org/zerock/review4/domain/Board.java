package org.zerock.review4.domain;

import javax.persistence.*;

@Entity
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //키 생성 전략
    private Long bno;

    @Column(length = 500, nullable = false) //컬럼의 길이와 null 허용여부
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;
}
