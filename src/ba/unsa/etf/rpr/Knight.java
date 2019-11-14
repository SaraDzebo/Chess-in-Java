package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {
    private String pozicija;
    private Color color;
    public Knight(String pozicija,Color color){
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
        //ko iz konstruktora
        if(position.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if((!((position.charAt(0)>=65 && position.charAt(0)<=72) || (position.charAt(0)>=97 && position.charAt(0)<=104)))||(!(position.charAt(1)>=49 && position.charAt(1)<=56))){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }

        //konj-jedina figura koja moze preskakati druge
        //krece se kao L

        if(!((Math.abs(position.charAt(0)-pozicija.charAt(0))==2 && Math.abs(position.charAt(1)-pozicija.charAt(1))==1) || (Math.abs(position.charAt(1)-pozicija.charAt(1))==2 && Math.abs(position.charAt(0)-pozicija.charAt(0))==1))){
        throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");}
        this.setPozicija(position);

    }
}
