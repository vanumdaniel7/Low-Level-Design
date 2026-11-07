package lld.practice.urlshortener;

import java.time.LocalDateTime;
import java.util.Optional;

public class UrlShortener {
    private final DefaultObservable<UrlEvent> urlEventObservable;
    private KeyGenerationStrategy keyGenerationStrategy;
    private UrlRepository urlRepository;
    private String domain;

    private static final int MAX_RETRIES = 10;

    private UrlShortener() {
        this.urlEventObservable = new DefaultObservable<>();
    }

    public UrlShortener getInstance() {
        return Holder.INSTANCE;
    }

    public String shorten(String longUrl) {
        Optional<String> existingShortKey = urlRepository.findShortKey(longUrl);
        if (existingShortKey.isPresent()) {
            return domain + existingShortKey.get();
        }

        String shortKey = claimUniqueKey(longUrl);
        ShortenedUrlData shortenedUrlData = new ShortenedUrlData(longUrl, shortKey, LocalDateTime.now());

        // urlRepository.save(shortenedUrlData);
        urlEventObservable.onValueChanged(new UrlEvent.UrlCreatedEvent(shortenedUrlData));
        return domain + shortKey;
    }

    public String shortenWithAlias(String longURL, String alias) {
        ShortenedUrlData shortenedUrlData = new ShortenedUrlData(longURL, alias, LocalDateTime.now());
        if (!urlRepository.saveIfAbsent(shortenedUrlData)) {
            throw new RuntimeException("Alias already taken: " + alias);
        }
        this.urlEventObservable.onValueChanged(new UrlEvent.UrlCreatedEvent(shortenedUrlData));
        return domain + alias;
    }

    public Optional<String> resolve(String shortUrl) {
        if (!shortUrl.startsWith(domain)) {
            return Optional.empty();
        }

        String shortKey = shortUrl.replace(domain, "");
        Optional<ShortenedUrlData> shortenedUrlData = urlRepository.findShortenUrlData(shortKey);

        return shortenedUrlData.map(ShortenedUrlData::longUrl);
    }

    private String claimUniqueKey(String longUrl) {
        for (int i = 0; i < MAX_RETRIES; i++) {
            String potentialKey = keyGenerationStrategy.generate(urlRepository.getNextId());
            ShortenedUrlData shortenedUrlData = new ShortenedUrlData(longUrl, potentialKey, LocalDateTime.now());
            if (!urlRepository.saveIfAbsent(shortenedUrlData)) {
                return potentialKey;
            }
        }

        throw new RuntimeException("Failed to generate a unique short key after " + MAX_RETRIES + " attempts.");
    }

    private static class Holder {
        private static final UrlShortener INSTANCE = new UrlShortener();
    }
}
