package ba.unsa.etf.rpr;

public abstract class ChessPiece {

    public  enum Color{BLACK,WHITE}


    public ChessPiece(){} //konstruktor bez parametara


    public int helpFunction(char znak){
        int y=0;
        if(znak=='A')
            y=0;
        if(znak=='B')
            y=1;
        if(znak=='C')
            y=2;
        if(znak=='D')
            y=3;
        if(znak=='E')
            y=4;
        if(znak=='F')
            y=5;
        if(znak=='G')
            y=6;
        if(znak=='H')
            y=7;
        if(znak=='8')
            y=0;
        if(znak=='7')
            y=1;
        if(znak=='6')
            y=2;
        if(znak=='5')
            y=3;
        if(znak=='4')
            y=4;
        if(znak=='3')
            y=5;
        if(znak=='2')
            y=6;
        if(znak=='1')
            y=7;
        return y;

    }

    public abstract Color getColor();

     public abstract String getPosition();

    public abstract void move(String position) throws IllegalChessMoveException;



}
