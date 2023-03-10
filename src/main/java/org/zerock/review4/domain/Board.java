package org.zerock.review4.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //키 생성 전략
    private Long bno;

    private String title;

    private String content;

    private String writer;
}
