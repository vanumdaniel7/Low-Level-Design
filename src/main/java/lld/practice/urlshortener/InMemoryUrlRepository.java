package lld.practice.urlshortener;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUrlRepository implements UrlRepository {

    private final Map<String, ShortenedUrlData> shortKeyToUrlData;
    private final Map<String, String> longUrlToShortKey;
    private AtomicInteger nextId;

    public InMemoryUrlRepository() {
        this.shortKeyToUrlData = new ConcurrentHashMap<>();
        this.longUrlToShortKey = new ConcurrentHashMap<>();
        this.nextId = new AtomicInteger(1);
    }

    @Override
    public Optional<String> findShortKey(String longUrl) {
        return Optional.ofNullable(longUrlToShortKey.get(longUrl));
    }

    @Override
    public long getNextId() {
        return this.nextId.getAndIncrement();
    }

    @Override
    public boolean existsByKey(String potentialKey) {
        return shortKeyToUrlData.get(potentialKey) != null;
    }

    @Override
    public Optional<ShortenedUrlData> findShortenUrlData(String shortKey) {
        return Optional.ofNullable(shortKeyToUrlData.get(shortKey));
    }

    @Override
    public void save(ShortenedUrlData shortenedUrlData) {
        this.shortKeyToUrlData.put(shortenedUrlData.shortKey(), shortenedUrlData);
        this.longUrlToShortKey.put(shortenedUrlData.longUrl(), shortenedUrlData.shortKey());
    }

    @Override
    public boolean saveIfAbsent(ShortenedUrlData url) {
        if (shortKeyToUrlData.putIfAbsent(url.shortKey(), url) == null) {
            longUrlToShortKey.put(url.longUrl(), url.shortKey());
            return true;
        }
        return false;
    }
}
