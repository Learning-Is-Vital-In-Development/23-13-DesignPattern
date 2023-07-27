package com.sim.factorypattern.service;

import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.dto.OAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sim.factorypattern.factory.OAuthFactory;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final OAuthFactory OAuthFactory;

    public OAuthResponse oAuthLogin(Provider provider, String accessToken){
        return OAuthFactory.login(provider, accessToken);
    }
}