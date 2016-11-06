/**
 * 
 */
package exception;

import org.springframework.http.HttpStatus;

/**
 * @author santosh
 *
 */
public class MyCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6724586714358231803L;
	private HttpStatus httpStatusCode;
	/**
	 * @param e
	 */
	public MyCustomException(Exception e) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param e
	 * @param string
	 * @param serviceUnavailable
	 */
	public MyCustomException(Exception e, String string, HttpStatus httpStatusCode) {
		super(string, e);
        this.httpStatusCode = httpStatusCode;
	}

	/**
	 * @param string
	 * @param ok
	 */
	public MyCustomException(String string, HttpStatus httpStatusCode) {
		super(string);
        this.httpStatusCode = httpStatusCode;
	}

}
