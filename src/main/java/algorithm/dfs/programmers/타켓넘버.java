package algorithm.dfs.programmers;

class 타겟넘버 {
    public int DFS(int L, int total, int target, int[] numbers){
        int count = 0;
        if(L==numbers.length){
            if(total == target) return 1;
        }
        else{
            count += DFS(L+1, total+numbers[L], target, numbers);
            count += DFS(L+1, total-numbers[L], target, numbers);
        }
        return count;
    }
    public int solution(int[] numbers, int target) {
        int answer = DFS(0,0,target, numbers);
        return answer;
    }
}
