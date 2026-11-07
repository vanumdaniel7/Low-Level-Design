package lld.practice.urlshortener;

public interface KeyGenerationStrategy {
    String generate(long nextId);
}
