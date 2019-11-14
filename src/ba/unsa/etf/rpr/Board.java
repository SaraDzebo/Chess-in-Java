package ba.unsa.etf.rpr;

public class Board {
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


    }

    //pomocna funkcija
    public int helpFunction(char znak) {
        int y = 0;
        if (znak == 'A')
            y = 0;
        if (znak == 'B')
            y = 1;
        if (znak == 'C')
            y = 2;
        if (znak == 'D')
            y = 3;
        if (znak == 'E')
            y = 4;
        if (znak == 'F')
            y = 5;
        if (znak == 'G')
            y = 6;
        if (znak == 'H')
            y = 7;
        if (znak == '8')
            y = 0;
        if (znak == '7')
            y = 1;
        if (znak == '6')
            y = 2;
        if (znak == '5')
            y = 3;
        if (znak == '4')
            y = 4;
        if (znak == '3')
            y = 5;
        if (znak == '2')
            y = 6;
        if (znak == '1')
            y = 7;
        return y;

    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        //velika-mala slova
        position = position.toUpperCase();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (fields[i][j] != null) {
                    if (fields[i][j].getClass() == type && fields[i][j].getColor().equals(color)) {
                        try {
                            //ukoliko dodje do izuzetka

                            fields[i][j].move(position);
                            fields[(position.charAt(1))][helpFunction(position.charAt(0))] = fields[i][j]; //matric
                            return;
                        }
                        catch (Exception izuzetak) {
                        }
                    }

                }
            }
        }

        throw new IllegalChessMoveException("Ne postoji figura za koju je zadani potez legalan!");
    }



    public boolean isCheck(ChessPiece.Color color){
        String string="";

        for(int i=0;i<fields.length;i++){
            for(int j=0;j<8;j++){
                if(fields[i][j]!=null) {
                    if (fields[i][j].getClass() == King.class && fields[i][j].getColor().equals(color)) {
                        string = fields[i][j].getPosition();
                    }
                }
            }
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(fields[i][j]!=null && !(fields[i][j].getColor().equals(color))){
                    //ukoliko dodje do izuzetka
                    try{
                        //za svaku klasu provjera

                        if(fields[i][j] instanceof Knight){
                            Knight glavni= new Knight(fields[i][j].getPosition(),fields[i][j].getColor());
                            glavni.move(string);
                            return true;
                        }
                        if(fields[i][j] instanceof Pawn){
                            Pawn glavni= new Pawn(fields[i][j].getPosition(),fields[i][j].getColor());
                            glavni.move(string);
                            return true;
                        }
                        if(fields[i][j] instanceof Bishop){
                            Bishop glavni= new Bishop(fields[i][j].getPosition(),fields[i][j].getColor());
                            glavni.move(string);
                            return true;
                        }
                        if(fields[i][j] instanceof King){
                            King glavni= new King(fields[i][j].getPosition(),fields[i][j].getColor());
                            glavni.move(string);
                            return true;
                        }
                        if(fields [i][j] instanceof Queen){
                            Queen glavni= new Queen(fields[i][j].getPosition(),fields[i][j].getColor());
                            glavni.move(string);
                            return true;
                        }

                        if(fields[i][j] instanceof Rook){
                            Rook glavni= new Rook(fields [i][j].getPosition(),fields [i][j].getColor());
                            glavni.move(string);
                            return true;
                        }

                    }
                    catch (Exception izuzetak){

                    }
                }
            }
        }
        return false;
    }


}

