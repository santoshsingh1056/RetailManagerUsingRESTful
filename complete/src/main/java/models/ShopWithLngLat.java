/**
 * 
 */
package models;

/**
 * @author santosh
 *
 */
public class ShopWithLngLat extends Shop {
	
	
	 private Double shoplatitude;
	 private Double shoplongitude;
	/**
	 * @param shop
	 */
	public ShopWithLngLat(Shop shop) {
		this.setShopName(shop.getShopName());
        this.setShopAddress(shop.getShopAddress());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shoplatitude == null) ? 0 : shoplatitude.hashCode());
		result = prime * result + ((shoplongitude == null) ? 0 : shoplongitude.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopWithLngLat other = (ShopWithLngLat) obj;
		if (shoplatitude == null) {
			if (other.shoplatitude != null)
				return false;
		} else if (!shoplatitude.equals(other.shoplatitude))
			return false;
		if (shoplongitude == null) {
			if (other.shoplongitude != null)
				return false;
		} else if (!shoplongitude.equals(other.shoplongitude))
			return false;
		return true;
	}
	/**
	 * @return the shoplatitude
	 */
	public Double getShoplatitude() {
		return shoplatitude;
	}
	/**
	 * @param shoplatitude the shoplatitude to set
	 */
	public void setShoplatitude(Double shoplatitude) {
		this.shoplatitude = shoplatitude;
	}
	/**
	 * @return the shoplongitude
	 */
	public Double getShoplongitude() {
		return shoplongitude;
	}
	/**
	 * @param shoplongitude the shoplongitude to set
	 */
	public void setShoplongitude(Double shoplongitude) {
		this.shoplongitude = shoplongitude;
	}
	/**
	 * @return
	 */
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location(getShoplongitude(), getShoplatitude());
	}
	
}
