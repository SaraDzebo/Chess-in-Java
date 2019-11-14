package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    private String pozicija;
    private Color color;
    public Pawn(String pozicija,Color color){
        this.pozicija=pozicija;
        this.color=color;
        if(pozicija.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if(!(pozicija.charAt(0)>=65 && pozicija.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104)){
throw new IllegalArgumentException("Pozicija se nalazi an tabele.");
        }
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
        if(pozicija.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if(!(pozicija.charAt(0)>=65 && pozicija.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104)){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }


    }
    }

