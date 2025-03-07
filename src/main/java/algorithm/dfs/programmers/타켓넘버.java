package algorithm.dfs.programmers;

class 타겟넘버 {
    int answer = 0;
    public void dfs(int[] numbers, int target, int level, int num){
        if(level == numbers.length-1){
            if(num==target){
                answer++;
            }
            return;
        }
        dfs(numbers,target,level+1,num+numbers[level+1]);
        dfs(numbers,target,level+1,num-numbers[level+1]);
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, -1, 0);
        return answer;
    }
}
