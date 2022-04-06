package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
    * == index.html이 왜 안나오고 아래의 home()이 실행될까? ==
    *
    * 정답은 순서 차이인데,
    * 요청이 오면 스프링 컨테이너 안에서 컨트롤러를 찾고
    * 없으면 static 파일을 찾는다.
    * welcome html은 /가 있기 때문에 안나온다.    * */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
