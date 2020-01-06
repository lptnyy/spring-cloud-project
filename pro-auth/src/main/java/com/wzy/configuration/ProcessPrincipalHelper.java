package com.wzy.configuration;

import com.wzy.pojo.sso.VaUser;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
public class ProcessPrincipalHelper {

    private static final String USER_NAME_KEY = "username";

    public static Object converter(Map<String, ?> map) {
        Map<String, Object> params = new HashMap<String, Object>();
        for(String key : map.keySet()) {
            params.put(key, map.get(key));
        }
        VaUser processUser = new VaUser((String) map.get(USER_NAME_KEY));
        try {
            BeanUtils.populate(processUser, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return processUser;
    }
}
