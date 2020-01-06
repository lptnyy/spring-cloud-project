package com.wzy.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class AuthorizationServerConifg extends AuthorizationServerConfigurerAdapter {
    @Value("${client}")
    String webClient;
    @Value("${secret}")
    String webSecret;
    @Value("${jwtSecret}")
    String jwtSecret;


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private WebResponseExceptionTranslator authWebResponseException;

    @Bean
    public AuthorizationServerEndpointsConfigurer getAuthorizationServerEndpointsConfigurer(){
        return new AuthorizationServerEndpointsConfigurer();
    }

    @Autowired
    TokenStore jwtTokenStore;

    @Autowired
    ProcessPrincipalHelper principalConverter;

    /**
     * 客户端一些配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(webClient)
                .scopes("web") //此处的scopes是无用的，可以随意设置
                .secret(webSecret)
                .authorizedGrantTypes("password", "authorization_code", "refresh_token");

    }

    /**
     * 配置jwttokenStore
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore).accessTokenConverter(jwtAccessTokenConverter());
        endpoints.authenticationManager(authenticationManager);
        endpoints.exceptionTranslator(authWebResponseException);
    }

    /**
     * springSecurity 授权表达式，访问merryyou tokenkey时需要经过认证
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(new PassWord())
                .tokenKeyAccess("permitAll()")
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        AdditionalJwtAccessTokenConverter jwtAccessTokenConverter = new AdditionalJwtAccessTokenConverter(principalConverter);
        jwtAccessTokenConverter.setSigningKey(jwtSecret);
        return jwtAccessTokenConverter;
    }

}
