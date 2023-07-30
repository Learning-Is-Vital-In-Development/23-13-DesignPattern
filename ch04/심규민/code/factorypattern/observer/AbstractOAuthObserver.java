package com.sim.factorypattern.observer;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.dto.OAuthResponse;
import com.sim.factorypattern.subject.OAuth;

public abstract class AbstractOAuthObserver implements Observer<OAuth, OAuthResponse> {
    @Override
    public OAuthResponse accept(OAuth status) {
        OAuthUserInfo oAuthUserInfo = attemptLogin(status.getAccessToken());
        return generateServerAccessTool(oAuthUserInfo);
    }

    protected abstract OAuthUserInfo attemptLogin(String accessToken);

    public abstract boolean isLogin(Provider provider);

    public final OAuthResponse generateServerAccessTool(OAuthUserInfo oAuthUserInfo) {
        return new OAuthResponse(oAuthUserInfo.getEmail()+" "+oAuthUserInfo.getUsername());
    }

}
