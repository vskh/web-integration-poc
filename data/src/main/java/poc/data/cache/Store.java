package poc.data.cache;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Store <Description>
 *
 * @author vadya
 */
public interface Store<K, V> extends Iterable<Map.Entry<K, V>> {

    StoreManager getStoreManager();

    <T> T unwrap(Class<T> clazz);

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    Map<K, V> getAll();

    Map<K, V> getAll(Set<K> keys);

    V put(K key, V value);

    void clear();

    Collection<V> query(StoreQuery<K, V> query);

    StoreQueryFactory queryFactory();
}
