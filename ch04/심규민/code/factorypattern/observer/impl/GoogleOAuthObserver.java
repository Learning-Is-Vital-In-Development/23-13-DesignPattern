package com.sim.factorypattern.observer.impl;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.observer.AbstractOAuthObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleOAuthObserver  extends AbstractOAuthObserver {
    private static final Provider PROVIDER = Provider.GOOGLE;

    @Override
    protected OAuthUserInfo attemptLogin(String accessToken) {
        log.info("GoogleOAuthObserver attemptLogin");
        return new OAuthUserInfo("Google username","Google email");
    }

    @Override
    public boolean isLogin(Provider provider) {
        log.info("GoogleOAuthObserver isLogin");
        return PROVIDER.equals(provider);
    }
}
