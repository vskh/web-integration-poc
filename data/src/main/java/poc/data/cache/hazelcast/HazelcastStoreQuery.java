package poc.data.cache.hazelcast;

import com.hazelcast.query.Predicate;
import poc.data.cache.StoreQuery;

/**
 * HazelcastStoreQuery <Description>
 *
 * @author vadya
 */
public class HazelcastStoreQuery<K, V> implements StoreQuery<K, V> {

    private Predicate<K, V> queryPredicate;

    public HazelcastStoreQuery(Predicate<K, V> queryPredicate) {
        this.queryPredicate = queryPredicate;
    }

    public <T> T unwrap(Class<T> clazz) {
        if (!clazz.isAssignableFrom(Predicate.class))
            throw new IllegalArgumentException("HazelcastStoreQuery can't be unwrapped into " + clazz.getCanonicalName() + " instance");

        return clazz.cast(queryPredicate);
    }
}
