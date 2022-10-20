import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week3.algorithm_1019.stack.StackPractice;

import static org.junit.jupiter.api.Assertions.*;

class StackPracticeTest {

    @BeforeEach
    void setUp(){
        System.out.println("before each");
    }

    @Test
    @DisplayName("push가 잘 되는지?")
    void pushTest() {
        StackPractice sp = new StackPractice();
        sp.push(10);
        sp.push(20);

        int[] arr=sp.getArr();

        Assertions.assertEquals(10,arr[0]);
        Assertions.assertEquals(20,arr[1]);
    }

    @Test
    @DisplayName("push가 잘 되는지 pop이 되는지")
    void pushAndPop() {
        StackPractice sp = new StackPractice();
        sp.push(10);
        sp.push(20);
        int[] arr = sp.getArr();
        Assertions.assertEquals(20,arr[sp.getPointer()]);
        sp.pop();
        Assertions.assertEquals(10,arr[sp.getPointer()]);

    }

    @Test
    @DisplayName("isEmpty가 잘 되는지")
    void isEmptyTest() {
        StackPractice sp = new StackPractice();
        sp.push(10);
        sp.push(20);
        int[] arr = sp.getArr();
        Assertions.assertEquals(20,arr[sp.getPointer()]);
        sp.pop();
        sp.pop();
        Assertions.assertEquals(true,sp.isEmpty());
    }

    @Test
    void peekTest() {
        StackPractice sp = new StackPractice();
        sp.push(10);
        sp.push(20);
        Assertions.assertEquals(20,sp.peek());
    }
}