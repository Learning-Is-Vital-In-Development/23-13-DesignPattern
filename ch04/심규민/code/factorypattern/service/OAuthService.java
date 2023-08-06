package com.sim.factorypattern.service;

import com.sim.factorypattern.dto.OAuthResponse;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.factory.OAuthFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final OAuthFactory oAuthFactory;

    public OAuthResponse oAuthLogin(Provider provider, String accessToken){
        return oAuthFactory.login(provider, accessToken);
    }
}