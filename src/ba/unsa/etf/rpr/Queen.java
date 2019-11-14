package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {
    private String pozicija;
    private Color color;

    public Queen(String pozicija, Color color) {
        if (pozicija.length() != 2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if ((!((pozicija.charAt(0) >= 65 && pozicija.charAt(0) <= 72) || (pozicija.charAt(0) >= 97 && pozicija.charAt(0) <= 104))) || (!(pozicija.charAt(1) >= 49 && pozicija.charAt(1) <= 56))) {
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }
        this.pozicija = pozicija;
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public String getPosition() {
        return pozicija;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        //iz konstruktora
        if (position.length() != 2) {
            throw new IllegalArgumentException("Pozicija nije u ispravnom formatu.");
        }
        if ((!((position.charAt(0) >= 65 && position.charAt(0) <= 72) || (pozicija.charAt(0) >= 97 && pozicija.charAt(0) <= 104))) || (!(position.charAt(1) >= 49 && position.charAt(1) <= 56))) {
            throw new IllegalArgumentException("Pozicija se nalazi van tabele.");
        }
        boolean je_li = false;
        if (Math.abs(position.charAt(0) - pozicija.charAt(0)) == Math.abs(position.charAt(1) - pozicija.charAt(1)))
            je_li = true;
        if (position.charAt(0) == position.charAt(0))
            je_li = true;
        if (position.charAt(1) == position.charAt(1))
            je_li = true;
        if (!je_li)
            throw new IllegalChessMoveException("Ovaj potez nije dozvoljen!");

        if (position.charAt(0) == pozicija.charAt(0)) {
            if (position.charAt(1) > pozicija.charAt(1)) {
                for (int i = helpFunction(position.charAt(1)) + 1; i < helpFunction(pozicija.charAt(1)); i++) {
                    if (Board.fields[i][helpFunction(position.charAt(0))] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }

            if (position.charAt(1) < pozicija.charAt(1)) {
                for (int i = helpFunction(position.charAt(1)) + 1; i < helpFunction(position.charAt(1)); i++) {
                    if (Board.fields[i][helpFunction(position.charAt(0))] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");

                }

            }
        }

        if (position.charAt(1) == pozicija.charAt(1)) {
            if (helpFunction(position.charAt(0)) < helpFunction(pozicija.charAt(0))) {
                for (int i = helpFunction(position.charAt(0)) + 1; i < helpFunction(pozicija.charAt(0)); i++) {
                    if (Board.fields[helpFunction(position.charAt(1))][i] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }
            if (helpFunction(position.charAt(0)) > helpFunction(pozicija.charAt(0))) {
                for (int i = helpFunction(position.charAt(0)) + 1; i < helpFunction(position.charAt(0)); i++) {
                    if (Board.fields[helpFunction(position.charAt(1))][i] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }
        }

        if (helpFunction(pozicija.charAt(1)) < helpFunction(position.charAt(1)) && helpFunction(pozicija.charAt(0)) > helpFunction(position.charAt(0))) {
            for (int i = helpFunction(pozicija.charAt(1)) + 1; i < helpFunction(position.charAt(1)); i++) {
                for (int j = helpFunction(position.charAt(0)) + 1; j < helpFunction(pozicija.charAt(0)); j++) {
                    if (i + j == helpFunction(pozicija.charAt(0)) + helpFunction(pozicija.charAt(1)) && Board.fields[i][j] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }
        }

        if (helpFunction(pozicija.charAt(1)) < helpFunction(position.charAt(1)) && helpFunction(pozicija.charAt(0)) < helpFunction(position.charAt(0))) {
            for (int i = helpFunction(pozicija.charAt(1)) + 1; i < helpFunction(position.charAt(1)); i++) {
                for (int j = helpFunction(pozicija.charAt(0)) + 1; j < helpFunction(position.charAt(0)); j++) {
                    if (i + helpFunction(pozicija.charAt(0)) == j && Board.fields[i][j] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }
        }
        if (helpFunction(pozicija.charAt(0)) > helpFunction(position.charAt(0)) && helpFunction(pozicija.charAt(1)) > helpFunction(position.charAt(1))) {
            for (int i = helpFunction(position.charAt(1)) + 1; i < helpFunction(pozicija.charAt(1)); i++) {
                for (int j = helpFunction(position.charAt(0)) + 1; j < helpFunction(pozicija.charAt(0)); j++) {
                    if (i -(helpFunction(position.charAt(1))+1)==j - (helpFunction(position.charAt(0))+1) && Board.fields[i][j] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }
        }

        if (helpFunction(pozicija.charAt(0)) < helpFunction(position.charAt(0)) && helpFunction(pozicija.charAt(1)) > helpFunction(position.charAt(1))) {
            for (int i = helpFunction(position.charAt(1)) + 1; i < helpFunction(pozicija.charAt(1)); i++) {
                for (int j = helpFunction(pozicija.charAt(0)) + 1; j < helpFunction(position.charAt(0)); j++) {
                    if (i + j == helpFunction(pozicija.charAt(0)) + helpFunction(pozicija.charAt(1)) && Board.fields[i][j] != null)
                        throw new IllegalChessMoveException("Ovdje nije dozvoljeno preskakanje figura!");
                }
            }
        }


        this.setPozicija(position);
    }
}



