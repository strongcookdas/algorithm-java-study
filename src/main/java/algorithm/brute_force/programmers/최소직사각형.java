package algorithm.brute_force.programmers;

public class 최소직사각형  {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int widthMax = Integer.MIN_VALUE, heightMax = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            widthMax = Math.max(widthMax,sizes[i][0]);
            heightMax = Math.max(heightMax, sizes[i][1]);
        }

        if(widthMax>heightMax){
            heightMax = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                if(sizes[i][1]>sizes[i][0]) heightMax = Math.max(sizes[i][0],heightMax);
                else heightMax = Math.max(sizes[i][1],heightMax);
            }
        }else{
            widthMax = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                if(sizes[i][0]>sizes[i][1]) widthMax = Math.max(sizes[i][1],widthMax);
                else widthMax = Math.max(sizes[i][0],widthMax);
            }
        }
        return widthMax*heightMax;
    }
}

/*
이 코드가 잘 작성된 코드같다.
class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int widthMax = Integer.MIN_VALUE, heightMax = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            widthMax = Math.max(widthMax,Math.max(sizes[i][0],sizes[i][1])); // 가로 세로에서 큰 값 중 최댓값
            heightMax = Math.max(heightMax,Math.min(sizes[i][0],sizes[i][1])); // 가로 세로에서 작은 값 중 최댓값
        }
        return widthMax*heightMax;
    }
}
 */
