import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlyTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Fly testSubject;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        testSubject = new Fly("Test_Fly");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void testEat1() throws Exception {
        testSubject.eat(new Ant("Food_Ant"));
        assertTrue(outContent.toString().contains("Test_Fly Fly won't eat a Food_Ant Ant."));
    }

    @Test
    public void testEat2() throws Exception {
        testSubject.eat(new Thing("Food_Thing"));
        assertTrue(outContent.toString().contains("Test_Fly Fly has eaten a Food_Thing Thing."));

    }

    @Test
    public void testMove() throws Exception {
        testSubject.move();
        assertTrue(outContent.toString().contains("Test_Fly Fly is buzzing around in flight."));
    }

    @Test
    public void testFly() throws Exception {
        testSubject.fly();
        assertTrue(outContent.toString().contains("Test_Fly Fly is buzzing around in flight."));
    }

    @Test
    public void testWhatDidYouEat1() throws Exception {
        testSubject.whatDidYouEat();
        assertTrue(outContent.toString().contains("Test_Fly Fly has had nothing to eat!"));
    }

    @Test
    public void testWhatDidYouEat2() throws Exception {
        testSubject.eat(new Thing("Food_Thing"));
        testSubject.whatDidYouEat();
        assertTrue(outContent.toString().contains("Test_Fly Fly has eaten a Food_Thing Thing"));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(testSubject.toString(), "Test_Fly Fly");
    }
}