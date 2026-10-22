package lld.patterns.builder;

import java.util.Map;

public class HttpRequest {
    private final String url;
    private final HttpMethod httpMethod;
    private final Map<String, String> queryParameters;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;

    private HttpRequest(HttpRequest.Builder builder) {
        this.url = builder.url;
        this.httpMethod = builder.httpMethod;
        this.queryParameters = Map.copyOf(builder.queryParameters);
        this.headers = Map.copyOf(builder.headers);
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    public static class Builder {
        private String url;
        private HttpMethod httpMethod;
        private Map<String, String> queryParameters;
        private Map<String, String> headers;
        private String body;
        private int timeout;

        public Builder(String url, HttpMethod httpMethod) {
            this.url = url;
            this.httpMethod = httpMethod;
        }

        public Builder addQueryParameters(Map<String, String> queryParameters) {
            this.queryParameters = queryParameters;
            return this;
        }

        public Builder addHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder addBody(String body) {
            this.body = body;
            return this;
        }

        public Builder addTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
