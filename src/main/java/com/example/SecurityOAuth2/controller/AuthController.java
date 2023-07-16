package com.example.SecurityOAuth2.controller;

import com.example.SecurityOAuth2.Dto.Request.KaKaoLoginParams;
import com.example.SecurityOAuth2.Dto.Request.NaverLoginParams;
import com.example.SecurityOAuth2.service.OAuthLoginService;
import com.example.SecurityOAuth2.config.AuthTokens;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final OAuthLoginService oAuthLoginService;

    @GetMapping("/loginForm")
    public String logininForm() {
        return "loginForm";
    }

    @PostMapping("/auth/kakao/callback")
    public ResponseEntity<AuthTokens> loginKakao(String code) {
        KaKaoLoginParams params = new KaKaoLoginParams(code);
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
    @PostMapping("/auth/naver/callback")
    public ResponseEntity<AuthTokens> loginNaver(String code) {
        NaverLoginParams params = new NaverLoginParams(code,"test");
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}