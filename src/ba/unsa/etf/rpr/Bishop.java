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
        //Bishop se moze samo dijagonalno kretati po svojoj boji
        if(Math.abs(position.charAt(0)-pozicija.charAt(0))!= Math.abs(position.charAt(1)-pozicija.charAt(1)))
            throw new IllegalChessMoveException("Ovaj potez nije dozvoljen");

        //Ispitujemo da li Bishop preskace figure tokom pomjeranja/ne moze
        if(helpFunction(pozicija.charAt(0))>helpFunction(position.charAt(0)) && helpFunction(pozicija.charAt(1))>helpFunction(position.charAt(1))){
            for(int i=helpFunction(position.charAt(1))+1;i<helpFunction(pozicija.charAt(1));i++){
                for(int j=helpFunction(position.charAt(0))+1;j<helpFunction(pozicija.charAt(0));j++){
                    if(i-(helpFunction(position.charAt(1))+1)==j-(helpFunction(position.charAt(0))+1) && Board.fields[i][j]!=null)throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura!");
                }
            }
        }


        if(helpFunction(pozicija.charAt(1))<helpFunction(position.charAt(1)) && helpFunction(pozicija.charAt(0))<helpFunction(position.charAt(0))){

            for(int i=helpFunction(pozicija.charAt(1))+1;i<helpFunction(position.charAt(1));i++){
                for(int j=helpFunction(pozicija.charAt(0))+1;j<helpFunction(position.charAt(0));j++){
                    if(i+helpFunction(pozicija.charAt(0))==j && Board.fields[i][j]!=null)throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura!");
                }
            }
        }

        if(helpFunction(pozicija.charAt(0))<helpFunction(position.charAt(0)) && helpFunction(pozicija.charAt(1))>helpFunction(position.charAt(1))){
            for(int i=helpFunction(position.charAt(1))+1;i<helpFunction(pozicija.charAt(1));i++){
                for(int j=helpFunction(pozicija.charAt(0))+1;j<helpFunction(position.charAt(0));j++){
                    if(i+j==helpFunction(pozicija.charAt(0))+helpFunction(pozicija.charAt(1)) && Board.fields[i][j]!=null)throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura!");
                }
            }
        }
        if(helpFunction(pozicija.charAt(1))<helpFunction(position.charAt(1)) && helpFunction(pozicija.charAt(0))>helpFunction(position.charAt(0))){

            for(int i=helpFunction(pozicija.charAt(1))+1;i<helpFunction(position.charAt(1));i++){
                for(int j=helpFunction(position.charAt(0))+1;j<helpFunction(pozicija.charAt(0));j++){
                    if(i+j==helpFunction(pozicija.charAt(0))+helpFunction(pozicija.charAt(1)) && Board.fields[i][j]!=null)
                        throw new IllegalChessMoveException("Nije dozvoljeno preskakanje figura");
                }
            }
        }



        this.setPozicija(position);
    }
}



