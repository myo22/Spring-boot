package org.zerock.review4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //어플리케이션의 main method가 있는 클래스에 적용하며 JPA Auditing(감시, 감사) 기능을 활성화하기 위한 어노테이션입니다. 해당 어노테이션을 적용함으로써 regDate, modDate처럼 DB에 데이터가 저장되거나 수정될 때 언제, 누가 했는지를 자동으로 관리할 수 있게 됩니다.
@SpringBootApplication            //그리고 아무런 설정잉 없는 상태인데 자동으로 데이터 베이스 관련 설정을 이용한다는 자동 설정 기능이 매우 좋다.
public class Review4Application { //스프링 부트는 이미 서버를 내장한 상태에서 만들어지기 때문에 스프링만을 이용할 때와 달리 별도의 WAS(Web Application Server)설정이 필요하지 않고 main() 실행을 통해서 프로젝트 실행
                                  //라이브러리는 자동으로 처리되고 빈설정은 XML대신 자바 설정을 이용한데 새로운 기법이지 기본과 다른 개념은 아니다. 그리고 Thymeleaf라는 템플린 엔질을 사용하는 경우가 많다.

    public static void main(String[] args) {
        SpringApplication.run(Review4Application.class, args);
    }

}
