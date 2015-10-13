package exception;


/** This application exception indicates that insert data could not processed.
 */
public class InsertException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public InsertException() {
    }

    public InsertException(String msg) {
        super(msg);
    }
}
