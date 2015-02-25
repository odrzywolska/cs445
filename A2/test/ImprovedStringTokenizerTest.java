import org.junit.Before;
import org.junit.Test;

import java.util.StringTokenizer;

import static org.junit.Assert.assertEquals;

public class ImprovedStringTokenizerTest {

    ImprovedStringTokenizer impToken;
    StringTokenizer token;

    @Before
    public void setUp() throws Exception {
        impToken = new ImprovedStringTokenizer("This class is easy");
        token = new StringTokenizer("This class is easy");
    }

    @Test
    public void testNextArray() throws Exception {
        String test[] = impToken.nextArray();
        assertEquals(test[0], "This");
        assertEquals(test[1], "class");
        assertEquals(test[2], "is");
        assertEquals(test[3], "easy");
    }

}