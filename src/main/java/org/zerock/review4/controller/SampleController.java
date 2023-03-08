package org.zerock.review4.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Log4j2
public class SampleController { //스프링 부트를 이용하여 웹을 개발하는 일은 컨트롤러나 화면을 개발하는 것과 유사하지만 web.xml이나 servlet-context.xml가 같은 웹 관련 설정 파일들이 없기 때문에
                                //이를 대신하는 클래스를 작성해준다.
    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello.........................");

        model.addAttribute("msg", "HELLO WORLD");
    }

    @GetMapping("/ex/ex1")
    public void ex1(Model model) {

        List<String> list = Arrays.asList("AAA", "BBB", "CCC", "DDD"); //Array를 List로 변환하는 것이다.

        model.addAttribute("list", list);
    }
}
