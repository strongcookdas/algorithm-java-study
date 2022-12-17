package algorithm.Like_lion.week8.algorithm_1122;

public class RecursionFunction {
    public void solution(int n){
        if(n>100) return;
        System.out.println(n);
        solution(++n);
    }

    public static void main(String[] args) {
        RecursionFunction r = new RecursionFunction();
        r.solution(1);
    }
}
