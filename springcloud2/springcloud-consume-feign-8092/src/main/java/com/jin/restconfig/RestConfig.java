package com.jin.restconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Autowired
    private RestTemplateBuilder bdr;

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return bdr.build();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
