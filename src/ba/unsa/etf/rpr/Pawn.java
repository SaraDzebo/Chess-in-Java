package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    private String position;
    private Color color;
    public Pawn(String position,Color color){
        this.position=position;
        this.color=color;
        if(position.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if(!(position.charAt(0)>=65 && position.charAt(0)<=72) || (position.charAt(0)>=97 && position.charAt(0)<=104)){
throw new IllegalArgumentException("Pozicija se nalazi an tabele.");
        }
    }
    @Override
    public Color getColor(){
        return color;
    }
    public void setPozicija(String pozicija){
        this.position=pozicija;
    }

    @Override
    public String getPosition() {
        return null;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {

    }
}
