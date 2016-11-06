/**
 * 
 */
package models;

/**
 * @author santosh
 *
 */
public class ShopAddress {
	
	private String number;
	private long postCode;
	
	public ShopAddress(){
		//no-arg
	}
    public ShopAddress(String number, long postCode) {
        this.number = number;
        this.postCode = postCode;
    }
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShopAddress [number=" + number + ", postCode=" + postCode + "]";
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the postCode
	 */
	public long getPostCode() {
		return postCode;
	}
	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(long postCode) {
		this.postCode = postCode;
	} 

}
