package exceptions;

public class DAOExcepetion extends Exception {
    private static final long serialVersionUID = 7054379063290825137L;

    public DAOExcepetion(String msg, Exception ex) {
        super(msg, ex);
    }
}
