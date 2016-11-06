/**
 * 
 */
package database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import models.ShopWithLngLat;

/**
 * @author santosh
 *
 */
public class ShopList {
	
	private List<ShopWithLngLat> shoplist = new ArrayList<ShopWithLngLat>();

    public ShopWithLngLat get(int index) {
        return shoplist.get(index);
    }

    public void add(ShopWithLngLat shopWithLngLat) {
    	shoplist.add(shopWithLngLat);
    }

    public void remove(ShopWithLngLat shopWithLngLat) {
    	shoplist.remove(shopWithLngLat);
    }

    public void remove(int index) {
    	shoplist.remove(index);
    }

    public List<ShopWithLngLat> getAll() {
        return Collections.unmodifiableList(shoplist);
    }

}
