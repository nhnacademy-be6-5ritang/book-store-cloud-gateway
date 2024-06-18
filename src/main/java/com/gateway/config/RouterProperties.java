package com.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@ConfigurationProperties(prefix = "bookstore")
public class RouterProperties {
    private String backendPath;

    private String backendUrl;

    private String authPath;

    private String authUrl;

    private String couponPath;

    private String couponUrl;
}
