import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week3.algorithm_1020.stack.StackPractice2;

import static org.junit.jupiter.api.Assertions.*;

class StackPractice2Test {

    @BeforeEach
    void setUp() {
        // 테스트 코드를 실행하기 전에 실행한다.
    }

    @Test
    @DisplayName("push test")
    void push() {
        StackPractice2 sp = new StackPractice2();
        sp.push(10);
        sp.push(20);
        Integer[] arr = sp.getArr();
        assertEquals(20, arr[1]);
        assertEquals(10, arr[0]);
    }

    @Test
    @DisplayName("pop test")
    void pop(){
        StackPractice2 sp = new StackPractice2();
        sp.push(10);
        sp.push(20);
        Integer[] arr = sp.getArr();
        assertEquals(20,sp.pop());
        assertEquals(10,sp.pop());
        assertEquals(-1,sp.getTop());//스택의 사이즈 체크
        //Exception의 검증
        assertThrows(RuntimeException.class,()->{
            sp.pop();
        });
    }

    @Test
    @DisplayName("isEmpty test")
    void isEmpty(){
        StackPractice2 sp = new StackPractice2();
        assertTrue(sp.isEmpty());
        sp.push(10);
        sp.pop();
        assertTrue(sp.isEmpty());
    }

}