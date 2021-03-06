/**
 * 
 */
package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import database.ShopList;
import exception.MyCustomException;
import models.Location;
import models.Shop;
import models.ShopAddress;
import models.ShopWithLngLat;
import util.Constants;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

/**
 * @author santosh
 *
 */
public class ShopLocatorService {
	
	
	 @Autowired
	private ShopList shopList;
	
	
	
	
	public void save(Shop shop) throws MyCustomException{
		
		
		ShopAddress	shopAdrs = shop.getShopAddress();
	
		Location location = geoApiResolver(shopAdrs.toString());
	
		ShopWithLngLat shopWithLngLat = new ShopWithLngLat(shop);
	
		shopWithLngLat.setShoplongitude(location.getLongitude());
	
		shopWithLngLat.setShoplatitude(location.getLatitude());
	
	    	shopList.add(shopWithLngLat);
		
	}
	
	
	public ShopWithLngLat nearest(Location location) throws MyCustomException{
		
	List<ShopWithLngLat> all = shopList.getAll();
        if(all == null || all.isEmpty()) {
            System.out.println("No shops added yet.");
            throw new MyCustomException("No Shop in list", HttpStatus.OK);
        }
        double nearest = calculateDistance(location, all.get(0).getLocation());
        double temp;
        ShopWithLngLat nearestShop = all.get(0);

        for(int i=1; i < all.size() ; i++) {
            temp = calculateDistance(location, all.get(i).getLocation());
            if (temp < nearest) {
                nearest = temp;
                nearestShop = all.get(i);
            }
        }

        if(nearest == 0.0) {
            System.out.println("Found shop with an exact location match.");
        }
        return nearestShop;
		
	}
	public List<ShopWithLngLat> getAll(){
		return null;
		
	}
	private Location geoApiResolver(String address) throws MyCustomException{
		GeoApiContext context = new GeoApiContext().setApiKey(Constants.GEO_API_KEY);
		
		try {
	        GeocodingResult result = GeocodingApi.geocode(context, address).await()[0];
	        LatLng location = result.geometry.location;
	        return new Location(location.lat,location.lng);
	    } catch (Exception e) {
	        System.out.println(">>>>>>>error from google geo api.");
	        throw new MyCustomException(e, "Unknown location.....Please try again",
	                HttpStatus.SERVICE_UNAVAILABLE);
	    }
	}
	
	private Double calculateDistance(Location l1, Location l2) {
        Double diff_lat = l1.getLatitude() - l2.getLongitude();
        Double diff_lon = l1.getLongitude() - l2.getLongitude();

        return Math.sqrt(diff_lat * diff_lat + diff_lon * diff_lon);
    }

}
