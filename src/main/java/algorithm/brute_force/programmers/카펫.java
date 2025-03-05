package algorithm.brute_force.programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int i = 1; i*i <= yellow; i++){
            if(yellow % i == 0){
                int row = yellow/i;
                int col = i;
                int totalBrown = ((row+2)*2)+(col*2);
                if(totalBrown == brown){
                    answer = new int[]{row + 2, col + 2};
                    break;
                }
            }
        }
        return answer;
    }
}