package com.wzy.configuration;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class AdditionalJwtAccessTokenConverter extends JwtAccessTokenConverter {
    private DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();

    private ProcessPrincipalHelper principalConverter;

    public AdditionalJwtAccessTokenConverter(ProcessPrincipalHelper principalConverter) {
        this.principalConverter = principalConverter;
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        UserAuthenticationConverter userAuthenticationConverter =
                new AdditonalUserAuthenticationConverter(principalConverter);
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        return accessTokenConverter.extractAuthentication(map);
    }
}
