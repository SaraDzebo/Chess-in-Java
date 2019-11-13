package ba.unsa.etf.rpr;

public class Board{
    public ChessPiece.Color color;
    public static ChessPiece[][] fields = new ChessPiece[8][8];


    public void setColor(ChessPiece.Color color) {
        this.color = color;
    }

    public ChessPiece.Color getColor() {
        return color;
    }

    //konstruktorza klasu Board pocetno stanje
    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fields[i][j] = null;


            }
        }
    }

        //ZA PIJUNE


    fields [1][0]=new Pawn("A7",ChessPiece.Color.BLACK);
    fields [1][1]=new Pawn("B7",ChessPiece.Color.BLACK);
    fields [1][2]=new Pawn("C7",ChessPiece.Color.BLACK);
    fields [1][3]=new Pawn("D7",ChessPiece.Color.BLACK);
    fields [1][4]=new Pawn("E7",ChessPiece.Color.BLACK);
    fields [1][5]=new Pawn("F7",ChessPiece.Color.BLACK);
    fields [1][6]=new Pawn("G7",ChessPiece.Color.BLACK);
    fields [1][7]=new Pawn("H7",ChessPiece.Color.BLACK);





    /*public boolean isCheck(ChessPiece.Color white) {
        return true;
    }

    public void move(String e2, String e4) {
    }

    public void move(Class<Pawn> pawnClass, ChessPiece.Color white, String e4) {
    }*/
}
