package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    private String pozicija;
    private Color boja;

    public Bishop(String pozicija, Color boja) {
        if (pozicija.length() != 2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if (!(pozicija.charAt(0) >= 65 && pozicija.charAt(0) <= 72) || (pozicija.charAt(0) >= 97 && pozicija.charAt(0) <= 104) || !(pozicija.charAt(1) <= 49 && pozicija.charAt(1) <= 56)) {
            throw new IllegalArgumentException("Pozicija se nalazi van sahovske table.");
        }
        this.pozicija = pozicija;
        this.boja = boja;
    }


    @Override
    public Color getColor() {
        return boja;
    }

    @Override
    public String getPosition() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        if (pozicija.length() != 2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if (!(pozicija.charAt(0) >= 65 && pozicija.charAt(0) <= 72) || (pozicija.charAt(0) >= 97 && pozicija.charAt(0) <= 104) || !(pozicija.charAt(1) <= 49 && pozicija.charAt(1) <= 56)) {
            throw new IllegalArgumentException("Pozicija se nalazi van sahovske table.");
        }

    }
}
