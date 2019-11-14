package ba.unsa.etf.rpr;

public class King extends ChessPiece{
    private String pozicija;
    private Color boja;
    //konsturktor klase King
    public King(String pozicija, Color boja) {
        if(pozicija.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if((!((pozicija.charAt(0)>=65 && pozicija.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104)))||(!(pozicija.charAt(1)>=49 && pozicija.charAt(1)<=56))){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }
        this.pozicija=pozicija;
        this.boja=boja;
    }



    @Override
    public Color getColor() {
        return boja;
    }

    @Override
    public String getPosition() {
        return pozicija;
    }
    public void setPozicija(String pozicija){
        this.pozicija=pozicija;
    }

    public void move(String position) throws IllegalChessMoveException {
        //iz konstruktora

        if(position.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if((!((position.charAt(0)>=65 && position.charAt(0)<=72) || (position.charAt(0)>=97 && position.charAt(0)<=104)))||(!(position.charAt(1)>=49 && position.charAt(1)<=56))){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }


        //kralj se moze pomjerati smao jedno mjesto:naprijed , nazad, sa strana i dijagonalno

        boolean pomjeranje = false;
        if (pozicija.charAt(0) == position.charAt(0) && ((position.charAt(0) + 1) == (pozicija.charAt(0) + 1) || (position.charAt(1)-1)==pozicija.charAt(1)))
            pomjeranje = true;

        if ((position.charAt(0) == (pozicija.charAt(0) + 1) && position.charAt(1) == (pozicija.charAt(1) + 1)) || (position.charAt(0) == (pozicija.charAt(0) - 1) && position.charAt(1) == (pozicija.charAt(1) - 1))
                || (position.charAt(0) == (pozicija.charAt(0) + 1) && position.charAt(1) == (pozicija.charAt(1) - 1)) || (position.charAt(0) == (pozicija.charAt(0) - 1) && position.charAt(1) == (pozicija.charAt(1) + 1)))
            pomjeranje = true;
        if (pozicija.charAt(1) == position.charAt(1) && ((position.charAt(0) + 1) == pozicija.charAt(0) || (position.charAt(0) - 1) == pozicija.charAt(0)))
            pomjeranje = true;
        if (!pomjeranje) throw new IllegalChessMoveException("Ovaj potez nije dozvoljen za kralja!");
        this.setPozicija(position);
    }
    }
