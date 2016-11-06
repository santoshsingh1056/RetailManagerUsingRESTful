/**
 * 
 */
package models;

/**
 * @author santosh
 *
 */
public class Shop {
	
	 private String shopName;
	 
	 private ShopAddress shopAddress;
	 
	 public Shop(){
		 
	 }
	 
	 public Shop(String shopName, String shopAddress_number, long shopAddress_postCode){
		 this.shopName = shopName;
		 this.shopAddress = new ShopAddress(shopAddress_number,shopAddress_postCode);
	 }
	 /**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopAddress
	 */
	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress the shopAddress to set
	 */
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}

	

}
