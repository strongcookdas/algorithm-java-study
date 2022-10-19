package week3.algorithm_1019.stack;

public class StackPractice {

    private  int[] arr = new int[10000];
    private int pointer = -1;
    public StackPractice(){}

    public StackPractice(int size){
        this.arr = new int[size];
    }
    public void push(int value){
        this.arr[++this.pointer] = value;
    }

    public int[] getArr() {
        return this.arr;
    }
}
