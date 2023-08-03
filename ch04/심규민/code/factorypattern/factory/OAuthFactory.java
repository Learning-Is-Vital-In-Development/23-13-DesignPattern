package com.sim.factorypattern.factory;


import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.dto.OAuthResponse;

public interface OAuthFactory {
    OAuthResponse login(Provider provider, String accessToken);
}
