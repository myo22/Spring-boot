package org.zerock.review4.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    class SampleDTO{
        private String p1, p2, p3;

        public String getP1(){
            return p1;
        }

        public String getP2(){
            return p2;
        }

        public String getP3(){
            return p3;
        }
    }

    //Thymeleaf의 고유한 기능들(인라인 기능)
    @GetMapping("/ex/ex2")
    public void ex2(Model model){

        log.info("ex/ex2.....................");

        List<String> strList = IntStream.range(1, 10) // 1에서 10까지 반복.
                .mapToObj(i -> "Data" + i)
                .collect(Collectors.toList());

        model.addAttribute("list", strList);

        Map<String, String> map = new HashMap<>();
        map.put("A", "AAAA");
        map.put("B", "BBBB");

        model.addAttribute("map", map);

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.p1 = "Value -- p1";
        sampleDTO.p2 = "Value -- p2";
        sampleDTO.p3 = "Value -- p3";

        model.addAttribute("dto", sampleDTO);
    }
}
