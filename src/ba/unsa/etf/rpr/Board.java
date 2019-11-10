package ba.unsa.etf.rpr;

public class Board {
    public ChessPiece.Color color;
    private char letter;
    private String number;

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


        //rucno unosenje figura-za bijele

        for (int i=0; i < 8; i++) {
            chessPieces[i] = new Pawn();
            chessPieces[i].setColor(ChessPiece.Color.WHITE);
            number= "2";
            letter= (char) ('A'+i);

            number=String.valueOf(letter)+number;
            chessPieces[i].setPosition(number);
            fields[6][0].setIs_free(false);
            fields[6][i].setPosition(number);
        }
    }


    public boolean isCheck(ChessPiece.Color white) {
        return true;
    }

    public void move(String e2, String e4) {
    }

    public void move(Class<Pawn> pawnClass, ChessPiece.Color white, String e4) {
    }
}
