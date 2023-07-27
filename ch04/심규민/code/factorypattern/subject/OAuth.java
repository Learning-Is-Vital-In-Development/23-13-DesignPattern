package com.sim.factorypattern.subject;

import com.sim.factorypattern.dto.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OAuth implements Status {
    private Provider provider;
    private String accessToken;
}
