package algorithm.dfs.programmers;

public class 단체사진찍기 {
    StringBuilder sb = new StringBuilder("");
    String[] word = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int[] ch = new int[8];
    int count = 0;

    public void dfs(int L, String[] data) {
        if (L == 8) {
            for (String s : data) {
                if (!compareData(s, sb.toString())) {
                    return;
                }
            }
            count++;
        } else {
            for (int i = 0; i < 8; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    sb.append(word[i]);
                    dfs(L + 1, data);
                    sb.delete(sb.length() - 1, sb.length());
                    ch[i] = 0;
                }
            }
        }
    }

    public boolean compareData(String data, String str) {
        int c1 = str.indexOf(data.charAt(0));
        int c2 = str.indexOf(data.charAt(2));
        int compareNum = Math.max(c1, c2) - Math.min(c1, c2) - 1;
        char compare = data.charAt(3);
        int n = data.charAt(4) - '0';
        if (compare == '=') {
            if (compareNum == n) {
                return true;
            } else {
                return false;
            }
        } else if (compare == '>') {
            if (compareNum > n) {
                return true;
            } else {
                return false;
            }
        } else {
            if (compareNum < n) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int solution(int n, String[] data) {
        dfs(0, data);
        return count;
    }
}