import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TigerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Tiger testSubject;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        testSubject = new Tiger("Test_Tiger");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void testMove() throws Exception {
        testSubject.move();
        assertTrue(outContent.toString().contains("Test_Tiger Tiger has just pounced."));
    }

    @Test
    public void testWhatDidYouEat1() throws Exception {
        testSubject.whatDidYouEat();
        assertTrue(outContent.toString().contains("Test_Tiger Tiger has had nothing to eat!"));
    }

    @Test
    public void testWhatDidYouEat2() throws Exception {
        testSubject.eat(new Ant("Food_Ant"));
        testSubject.whatDidYouEat();
        assertTrue(outContent.toString().contains("Test_Tiger Tiger has eaten a Food_Ant Ant"));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(testSubject.toString(), "Test_Tiger Tiger");
    }
}