package com.wzy.configuration.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wzy.common.util.ServiceResponse;
import com.wzy.configuration.exception.ProOAuth2Exception;
import java.io.IOException;

public class OAuth2ExceptionJacksonSerializer extends StdSerializer<ProOAuth2Exception> {

    protected OAuth2ExceptionJacksonSerializer() {
        super(ProOAuth2Exception.class);
    }

    @Override
    public void serialize(ProOAuth2Exception value, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
//        jgen.writeObjectField("status", value.getHttpErrorCode());
//        String errorMessage = value.getOAuth2ErrorCode();
//        if (errorMessage != null) {
//            errorMessage = HtmlUtils.htmlEscape(errorMessage);
//        }
//        jgen.writeStringField("msg", errorMessage);
//        if (value.getAdditionalInformation()!=null) {
//            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
//                String key = entry.getKey();
//                String add = entry.getValue();
//                jgen.writeStringField(key, add);
//            }
//        }
        jgen.writeObject(ServiceResponse.getAuthFAIL());
        jgen.writeEndObject();
    }
}

