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

    public int pop(){
        return this.arr[this.pointer--];
    }

    public boolean isEmpty(){
        return (this.pointer==-1)? true:false;
    }

    public int peek(){
        return arr[this.pointer];
    }

    public int[] getArr() {
        return this.arr;
    }

    public int getPointer() {
        return pointer;
    }
}
