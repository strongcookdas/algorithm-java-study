package algorithm.brute_force.boj;

import java.io.IOException;
import java.util.*;
public class 일곱난쟁이2309 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length -1;
        while(left<right){
            int tmp = arr[left]+arr[right];
            if(sum - tmp == 100){
                break;
            }else if(sum - tmp > 100){
                left ++;
            }else{
                right --;
            }
        }

        for(int i = 0; i<arr.length; i++){
            if(i==left || i==right){
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
