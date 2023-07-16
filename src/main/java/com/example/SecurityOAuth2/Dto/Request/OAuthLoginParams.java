package com.example.SecurityOAuth2.Dto.Request;

import com.example.SecurityOAuth2.entity.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {
    OAuthProvider oAuthProvider();

    MultiValueMap<String, String> makeBody();
}
