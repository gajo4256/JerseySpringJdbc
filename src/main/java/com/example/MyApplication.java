package com.example;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by gajo on 28.2.2015..
 */
public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication () {
        // Spring filter that provides a bridge between JAX-RS and Spring request attributes
        register(RequestContextFilter.class);
        // feature that registers Jackson JSON providers – needed for the application to understand JSON data
        register(JacksonFeature.class);
        register(MyResource.class);
    }
}
