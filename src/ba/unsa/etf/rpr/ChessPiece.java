package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    protected Color color;
    public static enum Color{BLACK,WHITE}
    protected String position;

    public ChessPiece(){} //konstruktor bez parametara
    //konstruktor sa parametrima
    public ChessPiece(Color color,String position){
      this.color=color;
      this.position=position;
    }

    public abstract Color getColor();

     public abstract String getPosition();

    public abstract void move(String position) throws IllegalChessMoveException;

    public abstract void setColor(Color color);





}
