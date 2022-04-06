package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    //AutoWired : 스프링 컨테이너에서 MemberSerivce를 가져옴
    //helloController -> memberService -> memberRepository
    //각 클래스마다 Autowired를 사용하여 DI(의존성 주입)을 진행함.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
