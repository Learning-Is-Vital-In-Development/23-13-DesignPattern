package com.sim.factorypattern.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class OAuthResponse {
    private final String serverToken;
}
