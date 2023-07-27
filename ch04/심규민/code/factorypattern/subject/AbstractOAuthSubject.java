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
public final class AbstractOAuthSubject implements Subject {
    private final List<AbstractOAuthObserver> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer<? extends Status> o) {
        observerList.add((AbstractOAuthObserver) o);
    }

    @Override
    public void removeObserver(Observer<? extends Status> o) {
        observerList.remove((AbstractOAuthObserver) o);
    }

    @Override
    public Object notifyObservers(Object object){
        if(object instanceof OAuthRequest oAuthRequest){
            return attemptLogin(new OAuth(oAuthRequest.getProvider(), oAuthRequest.getAccessToken()));
        }
        throw new IllegalArgumentException("지원하지 않은 소셜 로그인입니다.");
    }

    private OAuthResponse attemptLogin(OAuth oAuth){
        for (AbstractOAuthObserver abstractOAuthObserver : observerList) {
            if(abstractOAuthObserver.isLogin(oAuth.getProvider())){
                OAuthResponse oAuthResponse = (OAuthResponse) abstractOAuthObserver.accept(oAuth);
                log.info("status: {}", oAuthResponse);
                return oAuthResponse;
            }
        }
        throw new IllegalArgumentException("로그인 실패");
    }
}
