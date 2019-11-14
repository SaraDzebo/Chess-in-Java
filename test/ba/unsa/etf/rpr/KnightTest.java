package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );

    }

    @Test
    void getColor() {
        King king=new King("E1",ChessPiece.Color.WHITE);
        assertEquals(ChessPiece.Color.WHITE,king.getColor());
    }

    @Test
    void testMove() {
    }
}