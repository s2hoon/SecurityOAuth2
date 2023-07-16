package com.example.SecurityOAuth2.controller;

import com.example.SecurityOAuth2.Dto.Request.KaKaoLoginParams;
import com.example.SecurityOAuth2.Dto.Request.NaverLoginParams;
import com.example.SecurityOAuth2.Repository.MemberRepository;
import com.example.SecurityOAuth2.config.AuthTokens;
import com.example.SecurityOAuth2.entity.Member;
import com.example.SecurityOAuth2.service.OAuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final OAuthLoginService oAuthLoginService;
    private final MemberRepository memberRepository;

    @GetMapping("/loginForm")
    public String logininForm() {
        return "loginForm";
    }

    @GetMapping("/auth/kakao/callback")
    public ResponseEntity<AuthTokens> loginKakao(String code) {
        KaKaoLoginParams params = new KaKaoLoginParams(code);
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

    @GetMapping("/auth/naver/callback")
    public ResponseEntity<AuthTokens> loginNaver(String code) {
        NaverLoginParams params = new NaverLoginParams(code, "test");
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }


    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> allMembers = memberRepository.findAll();
        return ResponseEntity.ok(allMembers);
    }
}