package com.miniuber.gateway.filter;

import java.util.UUID;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Component
public class CorrelationIdFilter implements GlobalFilter, Ordered {
    public static final String HEADER = "X-Correlation-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String cid = headers.getFirst(HEADER);
        if (cid == null || cid.isBlank()) {
            cid = UUID.randomUUID().toString();
            exchange = exchange.mutate()
                    .request(builder -> builder.header(HEADER, cid))
                    .build();
        }
        // put it on response too
        exchange.getResponse().getHeaders().add(HEADER, cid);
        return chain.filter(exchange);
    }

    @Override public int getOrder() { return -1; }
}
