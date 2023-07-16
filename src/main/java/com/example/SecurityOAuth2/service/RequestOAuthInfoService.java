package com.example.SecurityOAuth2.service;

import com.example.SecurityOAuth2.Dto.Response.OAuthInfoResponse;
import com.example.SecurityOAuth2.Dto.Request.OAuthLoginParams;
import com.example.SecurityOAuth2.entity.OAuthProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component

public class RequestOAuthInfoService {

    private final Map<OAuthProvider, OAuthService> clients;

    public RequestOAuthInfoService(List<OAuthService> clients) {
        this.clients = clients.stream().collect(
                Collectors.toUnmodifiableMap(OAuthService::oAuthProvider, Function.identity())
        );
    }

    public OAuthInfoResponse request(OAuthLoginParams params) {
        OAuthService client = clients.get(params.oAuthProvider());
        String accessToken = client.requestAccessToken(params);
        return client.requestOauthInfo(accessToken);
    }

}
