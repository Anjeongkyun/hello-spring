package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //GET 방식
    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "hello!");
        return "hello";
    }

    //GET 파라미터 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) {

        model.addAttribute("name", name);
         return "hello-template";
    }

    //API 방식
    @GetMapping("hello-string")
    @ResponseBody
        public String helloString(@RequestParam(name = "name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    //Hello 클래스 생성
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
