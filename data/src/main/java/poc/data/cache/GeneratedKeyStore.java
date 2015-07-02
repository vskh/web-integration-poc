package poc.data.cache;

/**
 * ComputedKeyStore <Description>
 *
 * @author vadya
 */
public abstract class GeneratedKeyStore<K, V> implements Store<K, V> {

    private KeyGenerator<K, V> keyGenerator;

    public GeneratedKeyStore(KeyGenerator<K, V> keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    V put(V value) {
        return put(keyGenerator.computeKey(value), value);
    }

    public interface KeyGenerator<K, V> {
        K computeKey(V value);
    }
}
