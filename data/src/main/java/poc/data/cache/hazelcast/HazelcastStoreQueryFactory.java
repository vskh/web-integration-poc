package poc.data.cache.hazelcast;

import com.hazelcast.query.SqlPredicate;
import poc.data.cache.StoreQuery;
import poc.data.cache.StoreQueryFactory;

/**
 * HazelcastStoreQueryFactory <Description>
 *
 * @author vadya
 */
public class HazelcastStoreQueryFactory extends StoreQueryFactory {
    @Override
    public <K, V> StoreQuery<K, V> fromString(String s) {
        return new HazelcastStoreQuery<K, V>(new SqlPredicate(s));
    }
}
