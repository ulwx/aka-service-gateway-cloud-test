package com.example.gateway;

import com.github.ulwx.aka.gateway.filters.LoginInfo;
import com.github.ulwx.aka.gateway.filters.LoginInfoBuilder;
import com.ulwx.tool.ObjectUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Map;

public class MyTokenBuilder implements LoginInfoBuilder {
    @Override
    public LoginInfo build(ServerHttpRequest request, String proxiedResponseBody) {
        try {
            Map<String, Object> map = ObjectUtils.fromJsonToMap(proxiedResponseBody);
            String status=map.get("status")+"";
            if(status.equals("1")){
                Map<String,Object> data=(Map<String,Object> )map.get("data");
                String userId=data.get("userId")+"";
                LoginInfo loginInfo=new LoginInfo();
                loginInfo.setUser(userId);
                loginInfo.setSource("PC");
                loginInfo.setPhone("");
                loginInfo.setDeviceID("");
                loginInfo.setUserType("");
                return loginInfo;

            }
            return null;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
