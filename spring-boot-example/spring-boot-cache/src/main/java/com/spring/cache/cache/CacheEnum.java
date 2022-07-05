package com.spring.cache.cache;

public class CacheEnum {
    public static CacheEnum[] values() {
        CacheEnum[] cacheEnums = new CacheEnum[]{

        };

        return cacheEnums;
    }

    String name;
    long expires;

    public String getName() {
        return name;
    }

    public long getExpires() {
        return expires;
    }
}
