package javaProject.recipedia.controller;

import javaProject.recipedia.domain.Favs;
import javaProject.recipedia.domain.Member;
import javaProject.recipedia.domain.Token;
import javaProject.recipedia.dto.RequestMemberDto;
import javaProject.recipedia.dto.RequestTokenDto;
import javaProject.recipedia.dto.RespnoseFavsDto;
import javaProject.recipedia.dto.ResponseTokenDto;
import javaProject.recipedia.service.FavsService;
import javaProject.recipedia.service.MemberService;
import javaProject.recipedia.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;
    private final TokenService tokenService;
    private final FavsService favsService;

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
    public void joinUs(@RequestBody RequestMemberDto member) {
        memberService.join(member);
    }

    @PostMapping("/user/auth")
    @ResponseBody
    public ResponseTokenDto loginUs(@RequestBody RequestMemberDto member) {
//        System.out.println(member.getUserId());
//        System.out.println(member.getUserPassword());
        Member member1 = memberService.login(member);
        if (member1 != null) {
            // 토큰생성 -> userPk와 같이 token테이블에 저장
            String token = tokenService.createToken();     // 토큰 생성
            System.out.println(token);
            tokenService.insertToken(new Token(token, member1.getId()));   // userPk와 token을 token테이블에 저장
            return new ResponseTokenDto(token); //  json 형식으로 token 반환
        }
        System.out.println("fail");
        return null;  // 실패시 null 반환
    }

    @PostMapping("/user/log-out")
    public void logout(@RequestBody String token) {
        tokenService.deleteToken(token);
    }

    @ResponseBody
    @PostMapping("/recipe/set")
    public RequestTokenDto fvsAdd(@RequestBody RequestTokenDto requestToken) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜한 recipePk를 테이블에 추가한다.
        Long userPk = tokenService.findUserPkByToken(requestToken.getToken());
        favsService.addFavs(userPk, requestToken.getRecipePk());
        return requestToken;
    }

    @ResponseBody
    @DeleteMapping("/recipe/set")
    public RequestTokenDto fvsDel(@RequestBody RequestTokenDto requestToken) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜한 recipePk를 테이블에 삭제한다.
        Long userPk = tokenService.findUserPkByToken(requestToken.getToken());
        favsService.delFavs(userPk, requestToken.getRecipePk());
        return requestToken;
    }

    @ResponseBody
    @PostMapping("/user/recipe")
    public RespnoseFavsDto findRecipe(@RequestBody ResponseTokenDto responseDto) {
        // token에 맞는 userPk를 찾고 그 userPk로 찜 목록을 반환
        System.out.println(responseDto);
        Long userPk = tokenService.findUserPkByToken(responseDto.getToken());
        List<Favs> favs = favsService.getFavs(userPk);
        ArrayList<Long> recipePkList = new ArrayList<>();
        for (Favs fav : favs) {
            recipePkList.add(fav.getRecipePk());
        }
        return new RespnoseFavsDto(recipePkList);
    }
}

