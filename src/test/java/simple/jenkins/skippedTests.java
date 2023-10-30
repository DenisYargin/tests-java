package simple.jenkins;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class skippedTests {
    @Test
    @Disabled
    void someTest(){
        assertTrue(false);
    }

    @Test
    @Disabled("some reason")
    void someTest1(){
        assertTrue(false);
    }

}
