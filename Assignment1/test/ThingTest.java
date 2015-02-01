import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThingTest {

    @Test
    public void testToString() throws Exception {
        Thing testSubject = new Thing("Test_Thing");
        assertEquals(testSubject.toString(), "Test_Thing Thing");
    }
}