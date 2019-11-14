package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    private String pozicija;
    private Color color;
    public Pawn(String pozicija,Color color){
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
        if(position.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if((!((position.charAt(0)>=65 && position.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104)))||(!(position.charAt(1)>=49 && position.charAt(1)<=56))){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }
        boolean je_li=false;
        // za brojeve
        if(getColor()==Color.WHITE && position.charAt(1)<=pozicija.charAt(1))
throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");
        if(getColor()==Color.BLACK && position.charAt(1)>=pozicija.charAt(1))
            throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");
        if(Math.abs(pozicija.charAt(1)-position.charAt(1))>2) throw new IllegalChessMoveException("Ovaj potez nije dozvoljen");
        if(Math.abs(pozicija.charAt(1)-position.charAt(1))==2){
            if(pozicija.charAt(0)==position.charAt(0) && (pozicija.charAt(1)=='2' || pozicija.charAt(1)=='7')){
                this.setPozicija(position);
                return;
            }
        }

        if(Math.abs(pozicija.charAt(0)-position.charAt(0))>1) throw new IllegalChessMoveException("Ovaj potez nije dozvoljen");
        if(pozicija.charAt(0)==position.charAt(0)){
            if(getColor().equals(Color.WHITE)){
                if(Board.fields[helpFunction(pozicija.charAt(1))-1][helpFunction(pozicija.charAt(0))]!=null){
                    throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");
                }
            }
            else{
                if(Board.fields[helpFunction(pozicija.charAt(1))+1][helpFunction(pozicija.charAt(0))]!=null)
                    throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");
            }
        }

        if(Math.abs(pozicija.charAt(1)-position.charAt(1))==2){
            if(pozicija.charAt(0)!=position.charAt(0) || pozicija.charAt(1)!='2' || pozicija.charAt(1)!='7' || Board.fields[helpFunction(position.charAt(1))][helpFunction(position.charAt(0))]!=null)
                throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");
        }
        this.setPozicija(position);
    }
    }

