package week8.algorithm_1122;

public class RecursionFunction2 {
    public int solution(int[] arr,int n){
        if(n<0)return 0;
        return arr[n]+solution(arr,--n);
    }

    public static void main(String[] args) {
        RecursionFunction2 r = new RecursionFunction2();
        int[] arr = {1,2,3,4};
        System.out.println(r.solution(arr,arr.length-1));
    }
}
