package com.vendo.redis_lib.config;

public record PrefixProperties(String prefix, long ttl) {

    public PrefixProperties(String prefix, long ttl) {
        this.prefix = prefix;
        this.ttl = ttl;
    }

    public String buildPrefix(String value) {
        return prefix + value;
    }
}

