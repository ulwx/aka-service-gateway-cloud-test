package com.example.gateway;

import com.github.ulwx.aka.gateway.filters.FetchLogoutCondition;
import com.github.ulwx.aka.gateway.filters.LogoutCondition;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

public class MyFetchLogoutCondition implements FetchLogoutCondition {

    @Override
    public LogoutCondition fetch(String body, ServerWebExchange exchange) {
        LogoutCondition logoutCondition=new LogoutCondition();
        ServerHttpRequest serverHttpRequest=exchange.getRequest();
        ServerHttpResponse serverHttpResponse=exchange.getResponse();
        return logoutCondition;
    }
}
