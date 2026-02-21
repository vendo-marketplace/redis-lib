package com.vendo.redis_lib.config;

import java.util.Objects;

public class PrefixProperties {

    private String prefix;

    private long ttl;

    public PrefixProperties(String prefix) {
    }

    public PrefixProperties(String prefix, long ttl) {
        this.prefix = prefix;
        this.ttl = ttl;
    }

    public String buildPrefix(String value) {
        return prefix + value;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrefixProperties that = (PrefixProperties) o;
        return ttl == that.ttl && Objects.equals(prefix, that.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, ttl);
    }

    @Override
    public String toString() {
        return "PrefixProperties{" +
                "prefix='" + prefix + '\'' +
                ", ttl=" + ttl +
                '}';
    }
}
