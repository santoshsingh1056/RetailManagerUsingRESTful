/**
 * 
 */
package models;

/**
 * @author santosh
 *
 */
public class Location {
	
	private Double longitude;
	private Double latitude;


	/**
	 * @param lat
	 * @param lng
	 */
	public Location(double lat, double lng) {
		this.longitude = lng;
		this.latitude = lat;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
