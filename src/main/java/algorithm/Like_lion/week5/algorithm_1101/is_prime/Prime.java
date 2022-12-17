package algorithm.Like_lion.week5.algorithm_1101.is_prime;

public class Prime {
    public int solution(int n){
        int cnt=0;
        for (int i = 2; i <= n ; i++) {
            if(this.isPrime(i))
                cnt++;
        }

        return cnt;
    }

    public boolean isPrime(int num){
        for (int i = 2; i*i<=num ; i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }
}
