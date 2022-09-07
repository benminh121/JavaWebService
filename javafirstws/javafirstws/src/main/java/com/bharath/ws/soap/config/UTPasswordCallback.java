package com.bharath.ws.soap.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UTPasswordCallback implements CallbackHandler {
    private Map<String, String> passwords = new HashMap<>();
    public UTPasswordCallback(){
        passwords.put("ben","ben");
        passwords.put("cgv","cgv");
    }
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for(Callback callback: callbacks){
            WSPasswordCallback passwordCallBack = (WSPasswordCallback) callback;
            String password = passwords.get(passwordCallBack.getIdentifier());
            if (password!=null){
                passwordCallBack.setPassword(password);
                return;
            }
        }
    }
}
