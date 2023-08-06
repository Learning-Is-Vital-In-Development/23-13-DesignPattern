package com.sim.factorypattern.controller;

import com.sim.factorypattern.dto.OAuthResponse;
import com.sim.factorypattern.service.OAuthService;
import com.sim.factorypattern.dto.Provider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService oAuthService;

    @GetMapping("/oauth/{provider}")
    public OAuthResponse oAuthLogin(@PathVariable Provider provider, @RequestParam String accessToken){
        log.info("provider: {}, accessToken: {}", provider, accessToken);
        return oAuthService.oAuthLogin(provider, accessToken);
    }

}
