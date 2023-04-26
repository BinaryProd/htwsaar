import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.io.IOException;

public class PersonQueueTest {
    private PersonQueue q;

    @BeforeEach
    public void setup() {
        q = new PersonQueue(10);
        q.addLast(new Person("aabb", "xxxx"));
        q.addLast(new Person("aaab", "xxxx"));
        q.addLast(new Person("aAbb", "xxxx"));
    }

    @Test
    public void print() {
        try (ByteArrayOutputStream outContent = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(outContent));

            q.print();

            String expectedOutput = "aabb xxxx\naaab xxxx\naAbb xxxx";
            String actualOutput = outContent.toString().strip();
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }

    }

    @Test 
    public void smallset1() {
        String expected = "aAbb";
        assertEquals(expected, q.smallest());
    }

    @Test 
    public void smallset2() {
        q.removeLast();
        String expected = "aaab";
        assertEquals(expected, q.smallest());
    }

    @Test 
    public void smallset3() {
        q.addLast(new Person("a", "x"));;
        String expected = "a";
        assertEquals(expected, q.smallest());
    }
}
