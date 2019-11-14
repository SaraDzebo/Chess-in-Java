package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    private String pozicija;
    private Color color;
    public Rook(String pozicija,Color color){
        if(pozicija.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if((!((pozicija.charAt(0)>=65 && pozicija.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104)))||(!(pozicija.charAt(1)>=49 && pozicija.charAt(1)<=56))){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }
        this.pozicija=pozicija;
        this.color=color;
    }

    @Override
    public Color getColor(){
        return color;
    }
    public void setPozicija(String pozicija){
        this.pozicija=pozicija;
    }

    @Override
    public String getPosition()
    {
        return pozicija;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {

    }
}
