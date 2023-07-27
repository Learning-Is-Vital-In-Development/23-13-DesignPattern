package com.sim.factorypattern.factory;

import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.dto.OAuthRequest;
import com.sim.factorypattern.dto.OAuthResponse;
import com.sim.factorypattern.subject.AbstractOAuthSubject;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class OAuth2OAuthFactory implements OAuthFactory{
    private final AbstractOAuthSubject abstractOAuthSubject;

    @Override
    public OAuthResponse login(Provider provider, String accessToken) {
        return (OAuthResponse) abstractOAuthSubject.notifyObservers(new OAuthRequest(provider, accessToken));
    }
}
