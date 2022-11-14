package week7.algorithm_1114;

import java.util.Arrays;

public class Eratoste {
    public void solution(){
        int size = 51;
        boolean[] arr = new boolean[51];
        Arrays.fill(arr, true);

        for (int i = 2; i*i < arr.length; i++) {
            for (int j = i*2; j < arr.length; j+=i) {
                arr[j]=false;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if(arr[i])
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Eratoste e = new Eratoste();
        e.solution();
    }
}
