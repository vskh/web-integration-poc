package poc.data.cache.hazelcast;

import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicate;
import poc.data.cache.Store;
import poc.data.cache.StoreManager;
import poc.data.cache.StoreQuery;
import poc.data.cache.StoreQueryFactory;

import java.util.*;

/**
 * HazelcastStore <Description>
 *
 * @author vadya
 */
public class HazelcastStore<K, V> implements Store<K, V> {

    private StoreManager storeManager;
    private IMap<K, V> nativeImpl;

    protected HazelcastStore(StoreManager storeManager, IMap<K, V> nativeImpl) {
        this.storeManager = storeManager;
        this.nativeImpl = nativeImpl;
    }

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public <T> T unwrap(Class<T> clazz) {
        if (!clazz.isAssignableFrom(nativeImpl.getClass()))
            throw new IllegalArgumentException("HazelcastStore can't be unwrapped into " + clazz.getCanonicalName() + " instance");

        return clazz.cast(nativeImpl);
    }

    public boolean containsKey(K key) {
        return nativeImpl.containsKey(key);
    }

    public boolean containsValue(V value) {
        return nativeImpl.containsValue(value);
    }

    public V get(K key) {
        return nativeImpl.get(key);
    }

    public Map<K, V> getAll() {
        return Collections.unmodifiableMap(nativeImpl);
    }
    public Map<K, V> getAll(Set<K> keys) {
        return nativeImpl.getAll(keys);
    }

    public V put(K key, V value) {
        return nativeImpl.put(key, value);
    }

    public Collection<V> query(StoreQuery<K, V> query) {
        Predicate<K, V> p = query.unwrap(Predicate.class);

        return nativeImpl.values(p);
    }

    public void clear() {
        nativeImpl.clear();
    }

    public StoreQueryFactory queryFactory() {
        return new HazelcastStoreQueryFactory();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return nativeImpl.entrySet().iterator();
    }
}
