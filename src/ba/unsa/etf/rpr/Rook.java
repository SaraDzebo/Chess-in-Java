package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    private String pozicija;
    private Color boja;

    public Rook(String pozicija, Color boja) {
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

    @Override
    public void move(String position) throws IllegalChessMoveException {
        if(position.length()!=2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if((!((position.charAt(0)>=65 && position.charAt(0)<=72) || (pozicija.charAt(0)>=97 && pozicija.charAt(0)<=104)))||(!(position.charAt(1)>=49 && position.charAt(1)<=56))){
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }

        if(position.charAt(0)!=this.getPosition().charAt(0) && position.charAt(1)!=this.getPosition().charAt(1)) throw new IllegalChessMoveException("Potez nije dozvoljen");
        //ispitujemo da li se preskacu neke figure prilikom pomjeranja
        //top se moze kretati naprijed, nazad, sa strane koliko god mjesta ali bez preskakanja figura


            if(position.charAt(1)<pozicija.charAt(1)){
                for(int i=helpFunction(pozicija.charAt(1))+1;i<helpFunction(position.charAt(1));i++){
                    if(Board.fields[i][helpFunction(position.charAt(0))]!=null)throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura za pijun top!");
                }
            }

        if(position.charAt(1)==pozicija.charAt(1)) {
            if (helpFunction(position.charAt(0)) < helpFunction(pozicija.charAt(0))) {
                for (int i = helpFunction(position.charAt(0)) + 1; i < helpFunction(pozicija.charAt(0)); i++) {
                    if (Board.fields[helpFunction(position.charAt(1))][i] != null)
                        throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura za pijun top!");
                }
            }
        }

        if(position.charAt(0)==pozicija.charAt(0)){
            if(position.charAt(1)>pozicija.charAt(1)){
                for(int i=helpFunction(position.charAt(1))+1;i<helpFunction(pozicija.charAt(1));i++){
                    if(Board.fields[i][helpFunction(position.charAt(0))]!=null)throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura za pijun top!");
                }
            }
        }

        if(helpFunction(position.charAt(0))>helpFunction(pozicija.charAt(0))){
            for(int i=helpFunction(pozicija.charAt(0))+1;i<helpFunction(position.charAt(0));i++){
                if(Board.fields[helpFunction(position.charAt(1))][i]!=null)throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura za pijun top!");
            }
        }
        this.setPozicija(position);
    }
}