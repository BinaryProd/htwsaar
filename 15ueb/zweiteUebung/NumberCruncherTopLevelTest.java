    /**    
 * <h1> NumberCruncherTopLevelTest</h1>    
 *     
 * @author Victor Plage and David Glaser    
 * @version 1.0.    
 * @since 2023-04-11    
 */    
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;    
import org.junit.jupiter.api.Test;    
import static org.junit.jupiter.api.Assertions.*;    
    
public class NumberCruncherTopLevelTest {    
    
    private NumberCruncherTopLevel nc;    
    private float[] testArray = {-27.74f, 98.57f, 95.35f, 51.12f, -60.72f, -78.21f,    
        -85.77f, -6.32f, -69.54f, -48.64f, -95.91f, 83.72f, 7.79f, 92.13f, -81.07f, 9.71f,    
        -57.77f, -64.14f, 32.35f, -89.29f};    
    
    @BeforeEach    
    public void setUp() {    
        nc = new NumberCruncherTopLevel(testArray);    
    }    
    
    @Test    
    public void testConstructor() {    
        assertArrayEquals(testArray, nc.getNumbers());    
    }    
    
    @Test    
    public void testSum() {
        CrunchOperation sum = new Sum();
        sum.crunch(testArray);
        float[] expected = {-27.74f, 70.83f, 166.18f, 217.3f, 156.58f, 78.37f, -7.4f, -13.72f, -83.26f, -131.9f, -227.81f, -144.09f, -136.3f, -44.17f, -125.24f, -115.53f, -173.3f, -237.44f, -205.09f, -294.38f};
        assertArrayEquals(expected, nc.getNumbers(), 0.01f);
    }    

    @Test
    public void testSwirl() {
        float[] originalArray = Arrays.copyOf(testArray, testArray.length);
        CrunchOperation swirl = new Swirl();
        swirl.crunch(testArray);
        assertFalse(Arrays.equals(originalArray, nc.getNumbers()));
    }

    @Test
    public void testDivide() {
        CrunchOperation divide = new Divide();
        divide.crunch(testArray);
        float[] expected = {0.5703125f, -1.027734334f, -1.067868742f, -0.653624856f, -60.72f, -78.21f, -85.77f, 0.109399342f, -69.54f, -48.64f, -95.91f, -1.032687801f, -0.128293808f, -1.074151801f, -81.07f, -0.15138759f, -57.77f, -64.14f, -0.465199885f, -89.29f};
        assertArrayEquals(expected, nc.getNumbers(), 0.01f);
    }

    @Test
    public void testSubtract(){
        CrunchOperation subtract = new Subtract();
        subtract.crunch(testArray);
        float[] expected = {-27.74f, -126.31f, -221.66f, -272.78f, -212.06f, -133.85f, -48.08f, -41.76f, 27.78f, 76.42f, 172.33f, 88.61f, 80.82f, -11.31f, 69.76f, 60.05f, 117.82f, 181.96f, 149.61f, 238.9f};
        assertArrayEquals(expected, nc.getNumbers(), 0.01f);
    }

    @Test
    public void testAverage() {
        CrunchOperation average = new Average();
        average.crunch(testArray);
        float[] expected = {-27.74f, -14.21f, 95.35f, 51.12f, -60.72f, -78.21f, -85.77f, -6.32f, -69.54f, -48.64f, -95.91f, 83.72f, 7.79f, 92.13f, -81.07f, 9.71f, -57.77f, -64.14f, 32.35f, -89.29f}; 
        assertArrayEquals(expected, nc.getNumbers(), 0.01f);
    }
}
