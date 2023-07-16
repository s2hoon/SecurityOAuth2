package com.example.SecurityOAuth2.Dto.Response;

import com.example.SecurityOAuth2.entity.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}