package com.example.myblog.common.controller;

import org.springframework.boot.actuate.health.*;
import org.springframework.stereotype.Component;

@Component
public class HealthController extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception{
        builder.status(Status.UP).withDetail("Message", "API Health check success.").build();
    }
}
