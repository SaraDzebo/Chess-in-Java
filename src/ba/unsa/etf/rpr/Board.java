package ba.unsa.etf.rpr;

public class Board {
public ChessPiece.Color color;
private char letter;
private char number;

public Field[][] fields=new Field[8][8];
public ChessPiece[]chessPieces=new ChessPiece[32];

public void setColor(ChessPiece.Color color){
    this.color=color;
}




}
