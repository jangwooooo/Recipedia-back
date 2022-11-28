package javaProject.recipedia.controller;

import javaProject.recipedia.domain.Member;
import javaProject.recipedia.domain.Token;
import javaProject.recipedia.dto.RequestDto;
import javaProject.recipedia.service.MemberService;
import javaProject.recipedia.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;
    private final TokenService tokenService;

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
    @ResponseBody
    public String loginUs(@RequestBody RequestDto member) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPassword());
        Member member1 = memberService.login(member);
        if (member1 != null) {
            // 토큰생성 -> userPk와 같이 token테이블에 저장
            String token = tokenService.createToken();
            tokenService.insertToken(new Token(token, member1.getId()));
//            System.out.println(member1.getUserId());
//            System.out.println(member1.getUserPassword());
            return token;
            //  json 형식으로 token 반환
        }
        System.out.println("fail");
        return null;
        // 실패시 null 반환
    }

    @PostMapping("/user/log-out")
    public void logout(@RequestBody String token) {
    }

    @PostMapping("/recipe/set")
    public void fvsAdd(@RequestBody String token, Integer recipePk) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜한 recipePk를 테이블에 추가한다.

        Long userPk = tokenService.findUserPkByToken(token);
    }

    @DeleteMapping("/recipe/set")
    public void fvsdel(@RequestBody String token, Integer recipePk) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜한 recipePk를 테이블에 삭제한다.

        Long userPk = tokenService.findUserPkByToken(token);
    }

    @PostMapping("/user/recipe")
    public ArrayList<Integer> findRecipe(@RequestBody String token) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜 목록을 반환

        Long userPk = tokenService.findUserPkByToken(token);
        return new ArrayList<>();
    }
}

