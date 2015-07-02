package poc.data.publisher.service;

public interface CachePublisher<T> {
    void publish(T value);
}
