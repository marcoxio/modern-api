package com.packt.modern.api.hateoas;

import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.util.annotation.Nullable;

public interface HateoasSupport {
    default UriComponentsBuilder getUriComponentBuilder(@Nullable ServerWebExchange exchange) {
        if (exchange == null) {
            return UriComponentsBuilder.fromPath("/");
        }

        ServerHttpRequest request = exchange.getRequest();
        PathContainer contextPath = request.getPath().contextPath();

        return UriComponentsBuilder.fromHttpRequest(request)
                .replacePath(contextPath.toString())
                .replaceQuery("");
    }
}
