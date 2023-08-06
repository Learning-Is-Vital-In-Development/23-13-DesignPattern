package com.sim.factorypattern.config;

import com.sim.factorypattern.factory.OAuth2OAuthFactory;
import com.sim.factorypattern.factory.OAuthFactory;
import com.sim.factorypattern.observer.impl.GoogleOAuthObserver;
import com.sim.factorypattern.observer.impl.KakaoOAuthObserver;
import com.sim.factorypattern.observer.impl.NaverOAuthObserver;
import com.sim.factorypattern.subject.AbstractOAuthSubject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OAuthConfig {

    @Bean
    public AbstractOAuthSubject abstractOAuthSubject(){
        AbstractOAuthSubject abstractOAuthSubject = new AbstractOAuthSubject();
        abstractOAuthSubject.registerObserver(new GoogleOAuthObserver());
        abstractOAuthSubject.registerObserver(new KakaoOAuthObserver());
        abstractOAuthSubject.registerObserver(new NaverOAuthObserver());

        return abstractOAuthSubject;
    }

}
