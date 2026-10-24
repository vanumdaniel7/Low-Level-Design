package lld.examples.singleton;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public enum CacheManager {
    INSTANCE;
    private ConcurrentHashMap<String, CacheEntry> cacheMap;

    public void put(String key, String value, int timeToLeaveSeconds) {
        Instant expirySeconds = timeToLeaveSeconds < 0 ? null :
                Instant.now().plusSeconds(timeToLeaveSeconds);

        cacheMap.put(key, new CacheEntry(value, expirySeconds));
    }

    public String get(String key) {
        CacheEntry cacheEntry = cacheMap.get(key);
        return Instant.now().isAfter(cacheEntry.expirySeconds) ? null: cacheEntry.value;
    }

    private record CacheEntry(String value, Instant expirySeconds) {
        boolean isExpired() {
            return this.expirySeconds == null || Instant.now().isAfter(this.expirySeconds);
        }
    }
}
