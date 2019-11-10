package ba.unsa.etf.rpr;

public class IllegalChessMoveException extends Exception {
    public boolean have_error=false;

    public IllegalChessMoveException(){

    }

    public IllegalChessMoveException(String message){
    this.have_error=true;
    }

    public IllegalChessMoveException(String message,Throwable throwable) {
        this.have_error = true;
    }
}
