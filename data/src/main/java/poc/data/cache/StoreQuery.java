package poc.data.cache;

/**
 * StoreQuery <Description>
 *
 * @author vadya
 */
public interface StoreQuery<K, V> {
    <T> T unwrap(Class<T> clazz);
}
