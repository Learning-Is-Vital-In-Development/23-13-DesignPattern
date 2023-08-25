package com.sim.factorypattern.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OAuthRequest {
    private Provider Provider;
    private String accessToken;
}
