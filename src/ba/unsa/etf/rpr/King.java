package ba.unsa.etf.rpr;

public class King extends ChessPiece{
    private String pozicija;
    private Color boja;
    //konsturktor klase King
    public King(String pozicija, Color boja) {
        if(pozicija.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if(!(pozicija.charAt(0)>=65 && pozicija.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104) || !(pozicija.charAt(1)<=49 && pozicija.charAt(1)<=56)){
            throw new IllegalArgumentException("Pozicija se nalazi an tabele.");
        }
        this.pozicija=pozicija;
        this.boja=boja;
    }


    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public String getPosition() {
        return null;
    }

    public void move(String d2) {
    }
}