package ba.unsa.etf.rpr;

public class Board {
    public ChessPiece.Color color;
    private char letter;
    private char number;

    public Field[][] fields = new Field[8][8];
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
                fields[i][j] = new Field();
                //postavljanje na pocento
                fields[i][j].setIs_free(true);
            }
        }
    }
}
