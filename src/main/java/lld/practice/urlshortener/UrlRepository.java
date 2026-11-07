package lld.practice.urlshortener;

import java.util.Optional;

public interface UrlRepository {
    Optional<String> findShortKey(String longUrl);
    long getNextId();
    boolean existsByKey(String potentialKey);
    Optional<ShortenedUrlData> findShortenUrlData(String shortKey);
    void save(ShortenedUrlData shortenedUrlData);
    boolean saveIfAbsent(ShortenedUrlData shortenedUrlData);
}
