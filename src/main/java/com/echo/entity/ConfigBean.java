package com.echo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by echo on 2017/7/16.
 */
@ConfigurationProperties(prefix = "com.echo")
public class ConfigBean {

    private String name;
    private String want;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}
