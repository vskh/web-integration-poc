package poc.data.api.rest;

import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.data.cache.Store;
import poc.data.cache.StoreManager;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * StoreController <Description>
 *
 * @author vadya
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Inject
    private StoreManager storeManager;

    @RequestMapping("/{storeName}")
    public Collection<?> get(@PathVariable String storeName, @MatrixVariable(pathVar = "storeName") Map<String, List<String>> filterParams) {
        Store store = storeManager.getStore(storeName);
        String query = "";
        for (Map.Entry<String, List<String>> e : filterParams.entrySet()) {
            String subQuery = "";
            for (String value : e.getValue()) {
                subQuery += e.getKey() + "=" + value + " OR ";
            }
            if (!subQuery.isEmpty())
                subQuery = subQuery.substring(0, subQuery.length() - 4);
            query += subQuery + " AND ";
        }
        if (!query.isEmpty()) {
            query = query.substring(0, query.length() - 5);
            return store.query(store.queryFactory().fromString(query));
        } else {
            return store.getAll().values();
        }
    }
}
