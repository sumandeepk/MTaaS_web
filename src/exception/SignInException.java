package exception;
public class SignInException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public SignInException() {
    }

    public SignInException(String msg) {
        super(msg);
    }
}
