package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        /*model에 키는 data, 값은 hello!!로 넣어줌*/
        model.addAttribute("data", "hello!!");
        /*hello라는 이름의 html을  resources의 templates 패키지 안에서 찾아서
        모델 데이터 넘기면서 실행시킴*/
        return "hello";
    }

    @GetMapping("hello-mvc")
    /*파라미터로 받음 ^p키 눌러보면 requestparam의 파라미터를 알수있는데 required가 기본값이 true
    -> url에 ?name=spring과 같이 넣어줘야 제대로 동작함!*/
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        /*model에 담으면 view에서 렌더링할떄 사용함
        * 파라미터로 넘어온 name을 모델에 넘겨줌
        * key 값도 name*/
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    /*http의 바디부분에 이 데이터를 직접 넣어줌("hello" + name을 넣음)*/
    /*템플릿 엔진과의 차이는 뷰 없이 문자가 그대로 출력되는 것
    * 실행하고 페이지 소스보기를 해보면 그냥 문자만 출력된다*/
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    /*json 방식 - 키, 밸류로 이루어진 구조
    * ResponseBody는 기본적으로 json 방식을 사용함*/
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체 넘기기
    }

    /*static으로 만들면 컨트롤러 클래스 안에서 해당 클래스를 그냥 쓸 수 있음*/
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
