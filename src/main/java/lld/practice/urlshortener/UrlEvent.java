package lld.practice.urlshortener;

public sealed class UrlEvent permits UrlEvent.UrlAccessedEvent, UrlEvent.UrlCreatedEvent {
    private final ShortenedUrlData shortenedUrlData;

    public UrlEvent(ShortenedUrlData shortenedUrlData) {
        this.shortenedUrlData = shortenedUrlData;
    }

    public static final class UrlCreatedEvent extends UrlEvent {
        public UrlCreatedEvent(ShortenedUrlData shortenedUrlData) {
            super(shortenedUrlData);
        }
    }

    public static final class UrlAccessedEvent extends UrlEvent {
        public UrlAccessedEvent(ShortenedUrlData shortenedUrlData) {
            super(shortenedUrlData);
        }
    }
}
