package week6.algorithm_1107;

public class Hashad {
    public int solution(int num){
        int sum=0;
        while(num>0){
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Hashad h = new Hashad();
        System.out.println(h.solution(12));
    }
}
