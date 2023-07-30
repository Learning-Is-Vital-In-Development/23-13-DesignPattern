package com.sim.factorypattern.observer.impl;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.observer.AbstractOAuthObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoOAuthObserver extends AbstractOAuthObserver {
    private static final Provider PROVIDER = Provider.KAKAO;

    @Override
    protected OAuthUserInfo attemptLogin(String accessToken) {
        log.info("KakaoOAuthObserver attemptLogin");
        return new OAuthUserInfo("Kakao username","Kakao email");
    }

    @Override
    public boolean isLogin(Provider provider) {
        log.info("KakaoOAuthObserver isLogin");
        return PROVIDER.equals(provider);
    }
}
