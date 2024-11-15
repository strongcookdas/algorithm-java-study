package algorithm.math.programmers;

public class 약수의합 {
    public int solution(int n){
        int ans = 0;
        for (int i = 1 ; i*i <= n ; i++) {
            if(n%i==0){
                if(i*i==n){
                    ans+=i;
                }else{
                    ans+=i;
                    ans+=(n/i);
                }
            }
        }
        return ans;
    }
}
