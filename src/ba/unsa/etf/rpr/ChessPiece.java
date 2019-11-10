package ba.unsa.etf.rpr;

public class ChessPiece {
    protected Color color;
    public static enum Color{BLACK,WHITE}
    protected String position;

    public ChessPiece(){} //konstruktor bez parametara
    //konstruktor sa parametrima
    public ChessPiece(Color color,String position){
      this.color=color;
      this.position=position;
    }




}
