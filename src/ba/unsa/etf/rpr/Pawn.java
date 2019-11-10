package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(){}
    public Pawn( String color, Color white) {
    }

    @Override
    public String getPosition() {
        return null;
    }

    @Override
    public boolean move(String position) throws IllegalChessMoveException {
        return false;
    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public void setPosition(String position) {

    }
}
