package algorithm.brute_force.programmers;

public class 최소직사각형  {
    public int solution(int[][] sizes) {
        int rowMax = 0;
        int colMax = 0;

        for(int i = 0; i<sizes.length; i++){
            int row = sizes[i][0];
            int col = sizes[i][1];

            rowMax = Math.max(rowMax, Math.max(row, col));
            colMax = Math.max(colMax, Math.min(row, col));
        }

        return rowMax * colMax;
    }
}