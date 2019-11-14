package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueenTest {

    @Test
    void kraljicaPreskace() {
        Board b=new Board();
        assertAll(
                ()->assertThrows(
                        IllegalChessMoveException.class,
                        ()->b.move("D1","F3")
                ),
        ()->assertThrows(
                IllegalChessMoveException.class,
                ()->b.move("D1","F6")
                )

        );
    }
}