package fr.epu.bicycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void distanceTest() {
        Position p1 = new Position(3,4);
        Position p2 = new Position(7,1);
        double distance = p1.distance(p2);
        assertEquals(5, distance, 0.001);
        assertEquals(5, p2.distance(p1), 0.001);
    }

    @Test
    void isEquivalentTest() {
        Position p1 = new Position(3,4.002);
        Position p2 = new Position(2.999,4.001);
        assertTrue(p1.isEquivalent(p2));
        p2 = new Position(2.99,4);
        assertFalse(p1.isEquivalent(p2));
    }

    /**
     * Extract From F. Rallo TD and adapted.
     * @param args
     */
    public static void main(String[] args) {
        Position PositionA = new Position(1.0,1.0);
        Position PositionB = new Position(5.0,4.0);
        Position PositionC = new Position(1.0/3 , 3.141592);
        Position PositionD = new Position(0.3333333 , Math.PI);

        System.out.println("* --------------------------------------------------------- *");
        System.out.println("* TP java                    					            *");
        System.out.println("*                                                           *");
        System.out.println("* @author frederic rallo - frederic.rallo@univ-cotedazur.fr *");
        System.out.println("* @version TD2   - ex2                                      *");
        System.out.println("* --------------------------------------------------------- *");
        System.out.println();
        System.out.println();
        System.out.println ("Position A "+PositionA);
        System.out.println ("Position B "+PositionB);
        System.out.println ("Position C "+PositionC);
        System.out.println ("Position D "+PositionD);
        System.out.println ();
        System.out.println ("projection du Position A sur abscisses X = "+PositionA.projX() );
        System.out.println ("projection du Position A sur ordonnees Y = "+PositionA.projY() );
        System.out.println ("projection du Position B sur abscisses X = "+PositionB.projX() );
        System.out.println ("projection du Position B sur ordonnees Y = "+PositionB.projY() );
        System.out.println ();
        System.out.println ("Position A =?= A "+PositionA.isEquivalent(PositionA));
        System.out.println ("Position A =?= C "+PositionA.isEquivalent(PositionC));
        System.out.println ("Position C =?= D "+PositionC.isEquivalent(PositionD));
    }
}