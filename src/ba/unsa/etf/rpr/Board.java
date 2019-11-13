package ba.unsa.etf.rpr;

public class Board {
    //public ChessPiece.Color color;
    public static ChessPiece[][] fields = new ChessPiece[8][8];


    /*public void setColor(ChessPiece.Color color) {
        this.color = color;
    }*/

    /*public ChessPiece.Color getColor() {
        return color;
    }*/

    //konstruktorza klasu Board pocetno stanje
    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                fields[i][j] = null;
            }
        }


        //ZA PIJUNE


        fields[1][0] = new Pawn("A7", ChessPiece.Color.BLACK);
        fields[1][1] = new Pawn("B7", ChessPiece.Color.BLACK);
        fields[1][2] = new Pawn("C7", ChessPiece.Color.BLACK);
        fields[1][3] = new Pawn("D7", ChessPiece.Color.BLACK);
        fields[1][4] = new Pawn("E7", ChessPiece.Color.BLACK);
        fields[1][5] = new Pawn("F7", ChessPiece.Color.BLACK);
        fields[1][6] = new Pawn("G7", ChessPiece.Color.BLACK);
        fields[1][7] = new Pawn("H7", ChessPiece.Color.BLACK);

        fields[6][0] = new Pawn("A2", ChessPiece.Color.WHITE);
        fields[6][1] = new Pawn("B2", ChessPiece.Color.WHITE);
        fields[6][2] = new Pawn("C2", ChessPiece.Color.WHITE);
        fields[6][3] = new Pawn("D2", ChessPiece.Color.WHITE);
        fields[6][4] = new Pawn("E2", ChessPiece.Color.WHITE);
        fields[6][5] = new Pawn("F2", ChessPiece.Color.WHITE);
        fields[6][6] = new Pawn("G2", ChessPiece.Color.WHITE);
        fields[6][7] = new Pawn("H2", ChessPiece.Color.WHITE);

        //QUEENS
        fields[0][3] = new Queen("D8", ChessPiece.Color.BLACK);
        fields[7][3] = new Queen("D1", ChessPiece.Color.WHITE);
        //KINGS
        fields[0][4] = new King("E8", ChessPiece.Color.BLACK);
        fields[7][4] = new King("E1", ChessPiece.Color.WHITE);

        //KNIGHTS
        fields[0][1] = new Knight("B8", ChessPiece.Color.BLACK);
        fields[0][6] = new Knight("G8", ChessPiece.Color.BLACK);
        fields[7][6] = new Knight("G1", ChessPiece.Color.WHITE);
        fields[7][1] = new Knight("B1", ChessPiece.Color.WHITE);

        //BISHOPS
        fields[0][2] = new Bishop("C8", ChessPiece.Color.BLACK);
        fields[0][5] = new Bishop("F8", ChessPiece.Color.BLACK);
        fields[7][2] = new Bishop("C1", ChessPiece.Color.WHITE);
        fields[7][5] = new Bishop("F1", ChessPiece.Color.WHITE);

        // ROOKS
        fields[7][0] = new Rook("A1", ChessPiece.Color.WHITE);
        fields[7][7] = new Rook("H1", ChessPiece.Color.WHITE);
        fields[0][0] = new Rook("A8", ChessPiece.Color.BLACK);
        fields[0][7] = new Rook("H8", ChessPiece.Color.BLACK);








    /*public boolean isCheck(ChessPiece.Color white) {
        return true;
    }

    public void move(String e2, String e4) {
    }

    public void move(Class<Pawn> pawnClass, ChessPiece.Color white, String e4) {
    }*/
    }
}
