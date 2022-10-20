package week3.algorithm_1020.stack;

import java.util.EmptyStackException;

public class StackPractice2 {

    private Integer[] arr;
    private int top = -1;
    private int size;

    public int getTop() {
        return top;
    }

    public Integer[] getArr() {
        return arr;
    }

    public StackPractice2() {
        this.size = 10000;
        this.arr = new Integer[size];
    }

    public StackPractice2(int size) {
        this.size = size;
        this.arr = new Integer[this.size];
    }

    public void push(int value) {
        if(top==this.size-1){
            throw new StackOverflowError();
        }
        this.arr[++top] = value;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.arr[top--];
    }


    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    public int peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.arr[top];
    }
}
