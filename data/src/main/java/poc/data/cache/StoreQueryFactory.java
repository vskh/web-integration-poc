package poc.data.cache;

/**
 * StoreQueryFactory <Description>
 *
 * @author vadya
 */
public abstract class StoreQueryFactory {
    public abstract <K, V> StoreQuery<K, V> fromString(String s);
}
