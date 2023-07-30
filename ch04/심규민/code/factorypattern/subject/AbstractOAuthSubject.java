package com.sim.factorypattern.subject;

import com.sim.factorypattern.dto.OAuthRequest;
import com.sim.factorypattern.dto.OAuthResponse;
import com.sim.factorypattern.observer.AbstractOAuthObserver;
import com.sim.factorypattern.observer.Observer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class AbstractOAuthSubject implements Subject<OAuthRequest, OAuthResponse> {
    private final List<AbstractOAuthObserver> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer<? extends Status,OAuthResponse> o) {
        observerList.add((AbstractOAuthObserver) o);
    }

    @Override
    public void removeObserver(Observer<? extends Status, OAuthResponse> o) {
        observerList.remove((AbstractOAuthObserver) o);
    }

    @Override
    public OAuthResponse notifyObservers(OAuthRequest object) {
        return attemptLogin(new OAuth(object.getProvider(), object.getAccessToken()));
    }

    private OAuthResponse attemptLogin(OAuth oAuth) {
        for (AbstractOAuthObserver abstractOAuthObserver : observerList) {
            if (abstractOAuthObserver.isLogin(oAuth.getProvider())) {
                OAuthResponse oAuthResponse = abstractOAuthObserver.accept(oAuth);
                log.info("status: {}", oAuthResponse);
                return oAuthResponse;
            }
        }
        throw new IllegalArgumentException("로그인 실패");
    }
}
