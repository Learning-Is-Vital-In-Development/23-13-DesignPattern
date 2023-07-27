package com.sim.factorypattern.observer.impl;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.observer.AbstractOAuthObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NaverOAuthObserver extends AbstractOAuthObserver {
    private static final Provider PROVIDER = Provider.NAVER;

    protected OAuthUserInfo attemptLogin(String accessToken) {
        log.info("NaverOAuthObserver attemptLogin");
        return new OAuthUserInfo("Naver username","Naver email");
    }

    @Override
    public boolean isLogin(Provider provider) {
        log.info("NaverOAuthObserver isLogin");
        return PROVIDER.equals(provider);
    }
}
