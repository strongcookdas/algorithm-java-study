package algorithm.dynamic.programmers;
public class 타일링3N {
    long[] dp;
    public long solution(int n) {
        long mod = 1000000007L;
        dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        for(int i = 4; i<=n; i+=2){
            dp[i] = dp[i-2] * dp[2] %mod;
            for(int j = i-4; j>=0; j-=2){
                dp[i] = (dp[i] + dp[j]*2%mod)%mod;
            }
        }
        return dp[n]%mod;
    }
}