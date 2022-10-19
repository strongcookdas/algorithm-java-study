import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import week3.algorithm_1019.stack.StackPractice;

import static org.junit.jupiter.api.Assertions.*;

class StackPracticeTest {
    @Test
    void pushTest() {
        StackPractice sp = new StackPractice();
        sp.push(10);
        sp.push(20);

        int[] arr=sp.getArr();

        Assertions.assertEquals(10,arr[0]);
        Assertions.assertEquals(20,arr[1]);
    }
}