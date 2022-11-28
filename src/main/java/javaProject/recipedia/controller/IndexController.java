package javaProject.recipedia.controller;

import javaProject.recipedia.domain.Member;
import javaProject.recipedia.dto.RequestDto;
import javaProject.recipedia.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/favs")
    public String favs() {
        return "favs";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/user/create")
    public void joinUs(@RequestBody RequestDto member) {
        memberService.join(member);
    }

    @PostMapping("/user/auth")
    public String loginUs(@RequestBody RequestDto member) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPassword());
        Member member1 = memberService.login(member);
        if (member1 != null) {
//            System.out.println(member1.getUserId());
//            System.out.println(member1.getUserPassword());
            return "home";  // json 형식으로 token 반환
        }
        System.out.println("fail");
        return "login"; // 실패시 null 반환
    }

    @PostMapping("/user/log-out")
    public void logout(@RequestBody String token) {
    }

    @PostMapping("/recipe/set")
    public void fvsAdd(@RequestBody String token, Integer recipePk) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜한 recipePk를 테이블에 추가한다.
    }

    @DeleteMapping("/recipe/set")
    public void fvsdel(@RequestBody String token, Integer recipePk) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜한 recipePk를 테이블에 삭제한다.
    }

    @PostMapping("/user/recipe")
    public ArrayList<Integer> findRecipe(@RequestBody String token) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜 목록을 반환
        return new ArrayList<>();
    }
}

