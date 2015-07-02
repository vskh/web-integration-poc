package poc.data.cache.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Service;
import poc.data.cache.Store;
import poc.data.cache.StoreManager;

import javax.inject.Inject;
import java.util.Collection;

/**
 * HazelcastStoreManager <Description>
 *
 * @author vadya
 */
@Service
public class HazelcastStoreManager implements StoreManager {

    @Inject
    private HazelcastInstance instance;

    public <K, V> Store<K, V> getStore(String storeName) {
        return new HazelcastStore<K, V>(this, instance.<K, V>getMap(storeName));
    }

    public Collection<String> getStoreNames() {
        return instance.getConfig().getMapConfigs().keySet();
    }
}
