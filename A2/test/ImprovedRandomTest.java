import org.junit.Before;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImprovedRandomTest {
    ImprovedRandom irand;
    Random rand;


    @Before
    public void setUp() throws Exception {
        irand = new ImprovedRandom(0);
        rand = new Random(0);
    }

    @org.junit.Test
    public void testRangeInt() throws Exception {
        int test = irand.rangeInt(3,5);
        assertTrue(test >= 3);
        assertTrue(test <= 5);
    }


    @org.junit.Test
    public void testNextBytes() throws Exception {
        byte original[] = new byte[2];
        byte improved[] = new byte[2];
        irand.nextBytes(improved);
        rand.nextBytes(original);
        assertEquals(original[0], improved[0]);
        assertEquals(original[1], improved[1]);
    }

    @org.junit.Test
    public void testNextInt() throws Exception {
        assertEquals(irand.nextInt(), rand.nextInt());
    }

    @org.junit.Test
    public void testNextInt1() throws Exception {
        assertEquals(irand.nextInt(3), rand.nextInt(3));
    }

    @org.junit.Test
    public void testNextLong() throws Exception {
        assertEquals(irand.nextLong(), rand.nextLong());
    }

    @org.junit.Test
    public void testNextBoolean() throws Exception {
        assertEquals(irand.nextBoolean(), rand.nextBoolean());
    }

    @org.junit.Test
    public void testNextFloat() throws Exception {
        assertTrue(irand.nextFloat() == rand.nextFloat());
    }

    @org.junit.Test
    public void testNextDouble() throws Exception {
        assertTrue(irand.nextDouble() == rand.nextDouble());
    }

    @org.junit.Test
    public void testNextGaussian() throws Exception {
        assertTrue(irand.nextGaussian() == rand.nextGaussian());
    }
}