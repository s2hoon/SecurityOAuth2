package com.example.SecurityOAuth2.service;

import com.example.SecurityOAuth2.Dto.Response.OAuthInfoResponse;
import com.example.SecurityOAuth2.Dto.Request.OAuthLoginParams;
import com.example.SecurityOAuth2.entity.OAuthProvider;

public interface OAuthService {
    OAuthProvider oAuthProvider();

    String requestAccessToken(OAuthLoginParams params);

    OAuthInfoResponse requestOauthInfo(String accessToken);
}
