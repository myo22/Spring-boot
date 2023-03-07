package org.zerock.review4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Review4Application { //스프링 부트는 이미 서버를 내장한 상태에서 만들어지기 때문에 스프링만을 이용할 때와 달리 별도의 WAS(Web Application Server)설정이 필요하지 않고 main() 실행을 통해서 프로젝트 실행
                                  //라이브러리는 자동으로 처리되고 빈설정은 XML대신 자바 설정을 이용한데 새로운 기법이지 기본과 다른 개념은 아니다. 그리고 Thymeleaf라는 템플린 엔질을 사용하는 경우가 많다.

    public static void main(String[] args) {
        SpringApplication.run(Review4Application.class, args);
    }

}
