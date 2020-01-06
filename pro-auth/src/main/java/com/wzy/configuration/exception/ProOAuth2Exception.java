package com.wzy.configuration.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wzy.configuration.serializer.OAuth2ExceptionJacksonSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = OAuth2ExceptionJacksonSerializer.class)
public class ProOAuth2Exception extends OAuth2Exception {

    public ProOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public ProOAuth2Exception(String msg) {
        super(msg);
    }
}

