package poc.data.publisher.service;

/**
 * IntegrationCachePublisher <Description>
 *
 * @author vadya
 */
public interface IntegrationCachePublisher<T> extends CachePublisher<T> {
    void publish(T value);
}
