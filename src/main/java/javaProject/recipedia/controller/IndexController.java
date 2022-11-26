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

}

