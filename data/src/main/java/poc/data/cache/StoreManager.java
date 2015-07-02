package poc.data.cache;

import java.util.Collection;

/**
 * CacheManager <Description>
 *
 * @author vadya
 */
public interface StoreManager {
    <K, V> Store<K, V> getStore(String storeName);

    Collection<String> getStoreNames();
}
