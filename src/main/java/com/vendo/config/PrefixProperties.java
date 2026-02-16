package com.vendo.config;

import lombok.Data;

@Data
public class PrefixProperties {

    private String prefix;

    private long ttl;

    public String buildPrefix(String value) {
        return prefix + value;
    }

}
