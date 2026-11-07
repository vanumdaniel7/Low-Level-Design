package lld.practice.urlshortener;

import java.time.LocalDateTime;

public record ShortenedUrlData(String longUrl, String shortKey, LocalDateTime localDateTime) {
}
