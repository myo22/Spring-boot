package org.zerock.review4.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleJSONController { //API서버는 Thymeleaf처럼 서버에서 화면과 관련된 내용만 만들어 내는 것이 아니라 순수한 데이터만 전송하는 방식이다. 과거에는 주로 XML을 이용햇지만 최근에는 JSON(JavaScript Object Notation)을 이용한다.
                                    // 구조를 가진 데이터(객체)를 자바스크립트의 객체 표기법으로 표현한순수한 문자열이다. 문자열이므로 데이터 교환시에 프로그램 언어에 독립적이라는 장점이 있다.
    @GetMapping("/helloArr")
    public String[] helloArr() {

        log.info("helloArr.....................");

        return new String[]{"AAA", "BBB", "CCC"};
    }
}
