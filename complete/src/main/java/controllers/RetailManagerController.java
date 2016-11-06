/**
 * 
 */
package controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.MyCustomException;
import models.Location;
import models.Shop;
//import scala.sys.process.processInternal;
import services.ShopLocatorService;

/**
 * @author santosh
 *
 */
@RestController
public class RetailManagerController {
	
	@Autowired
	ShopLocatorService shopLocatorService;
	@Autowired
	ObjectMapper objectMapper;
	
	
	
	@RequestMapping("/")
    public String status() {
        return Constants.APP_START_SUCCESS;
	}
	@RequestMapping(path = "/shop/add", method = RequestMethod.GET)
	public String addShop(HttpServletResponse _response, 
						@RequestParam("shopName") String shopName,
			            @RequestParam("shopNumber") String shopAddress_number, 
			            @RequestParam("shopPostalCode") long shopAddress_postCode
						) throws MyCustomException
	{
		Shop shop = new Shop(shopName,shopAddress_number,shopAddress_postCode);
		String response;
		 try {
	            shopLocatorService.save(shop);
	            response = objectMapper.writeValueAsString(new Boolean(true));
	            _response.setStatus(HttpStatus.CREATED.value());
	        } catch (Exception e) {
	            System.out.println("Error while processing input during addShop");
	            throw new MyCustomException(e);
	        }
		 return response;
		 
	 }
	 
	 
	 
	 @RequestMapping(path = "/shop/nearest", method = RequestMethod.GET)
	    public String getNearestShop(@RequestParam("customerLatitude") String latitude,
	                                           @RequestParam("customerLongitude") String longitude) throws MyCustomException {
	        String result = null;
	        try {
	            Location location = new Location(Double.parseDouble(latitude), Double.parseDouble(longitude));
	            result = objectMapper.writeValueAsString(shopLocatorService.nearest(location));
	            return result;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid value for longitude - " + longitude + " or latitude - ");
	            throw new MyCustomException(e, "Invalid longitude and latitude", HttpStatus.BAD_REQUEST);
	        }
	        catch (Exception e) {
	        	System.out.println("Error in getting nearest shop for location with latitude <" + latitude + ">, longitude <" +longitude + ">");
	            throw new MyCustomException(e, "Service Unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	        }
	    }


}
