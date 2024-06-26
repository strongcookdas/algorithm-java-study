package algorithm.dfs.programmers;

public class 카카오프렌즈컬러링북 {
    int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    public int DFS(int x, int y, int color, int[][] arr) {
        int count = 1;
        arr[y][x] = 0;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < arr[0].length && nx >= 0 && ny < arr.length && ny >= 0 && arr[ny][nx] == color) {
                count += DFS(nx, ny, color, arr);
            }
        }
        return count;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(DFS(j, i, picture[i][j], picture), maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}