package algorithm.recursion.inflearn;

public class 재귀함수 {
    public static void DFS(int n){
        if(n==0) return;
        DFS(n-1);
        System.out.println(n);
    }

    public static void main(String[] args){
        DFS(3);
    }
}
