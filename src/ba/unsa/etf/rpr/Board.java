package ba.unsa.etf.rpr;

public class Board {
    public ChessPiece.Color color;
    private char letter;
    private String number;

    public static ChessPiece[][] fields = new ChessPiece[8][8];
    public ChessPiece[] chessPieces = new ChessPiece[32];

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



    /*public boolean isCheck(ChessPiece.Color white) {
        return true;
    }

    public void move(String e2, String e4) {
    }

    public void move(Class<Pawn> pawnClass, ChessPiece.Color white, String e4) {
    }*/
}
