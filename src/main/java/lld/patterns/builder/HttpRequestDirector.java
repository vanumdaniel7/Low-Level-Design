package lld.patterns.builder;

import java.util.Map;

public class HttpRequestDirector {

    HttpRequest buildSimpleGet(String url) {
        return new HttpRequest.Builder(url, HttpMethod.GET)
                .addHeaders(Map.of("Content-Type", "application/json"))
                .addTimeout(3000)
                .build();
    }

    HttpRequest buildAuthenticatedPost(String url, String token, String body) {
        return new HttpRequest.Builder(url, HttpMethod.POST)
                .addHeaders(Map.of("Authorization", "Bearer " + token))
                .addBody(body)
                .addTimeout(3000)
                .build();
    }
}
