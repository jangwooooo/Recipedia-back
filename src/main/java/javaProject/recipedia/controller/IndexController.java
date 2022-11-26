package javaProject.recipedia.controller;

import javaProject.recipedia.domain.Member;
import javaProject.recipedia.dto.RequestDto;
import javaProject.recipedia.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinUS")
    public String joinUs(@RequestBody RequestDto member) {
        memberService.join(member);
        return "login";
    }

    @PostMapping("/loginUs")
    public String loginUs(@RequestBody RequestDto member) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPassword());
        Member member1 = memberService.login(member);
        if (member1 != null) {
//            System.out.println(member1.getUserId());
//            System.out.println(member1.getUserPassword());
            return "home";
        }
        System.out.println("fail");
        return "login";
    }

}

