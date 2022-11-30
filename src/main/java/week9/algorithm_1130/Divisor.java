package week9.algorithm_1130;

public class Divisor {
    public int solution(int n){
        int ans = 0;
        for (int i = 1 ; i <= n ; i++) {
            if(Math.floorMod(n,i)==0) ans+=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Divisor().solution(5);
        System.out.println(ans);
    }
}
