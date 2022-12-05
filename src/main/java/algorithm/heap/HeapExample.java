package algorithm.heap;

import java.util.Arrays;

public class HeapExample {

    public static void childNode(int parentsNode){
        System.out.println("left child: "+(2*parentsNode+1));
        System.out.println("right child: "+(2*parentsNode+2));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,7,8};

        int temp  = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;
        System.out.println(Arrays.toString(arr));

        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.println(Arrays.toString(arr));

        childNode(5);
    }
}
