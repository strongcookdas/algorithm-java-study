package algorithm.bfs.boj;

import java.util.*;

public class 돌그룹12886 {
    int[] nums;

    public 돌그룹12886() {
        this.nums = new int[3];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        돌그룹12886 main = new 돌그룹12886();

        for (int i = 0; i < 3; i++) {
            main.nums[i] = kb.nextInt();
        }

        System.out.println(main.solution());
    }

    private int solution() {
        Queue<int[]> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.offer(new int[]{this.nums[0], this.nums[1], this.nums[2]});
        set.add(this.nums[0] + " " + this.nums[1] + " " + this.nums[2]);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                if (tmp[0] == tmp[1] && tmp[1] == tmp[2]) {
                    return 1;
                }
                int[] nArr1 = this.operate(tmp, 0, 1);
                String str1 = this.getString(nArr1);
                if (nArr1[0] > 0 && nArr1[1] > 0 && nArr1[2] > 0 && !set.contains(str1)) {
                    set.add(str1);
                    q.offer(nArr1);
                }
                int[] nArr2 = this.operate(tmp, 1, 2);
                String str2 = this.getString(nArr2);
                if (nArr2[0] > 0 && nArr2[1] > 0 && nArr2[2] > 0 && !set.contains(str2)) {
                    set.add(str2);
                    q.offer(nArr2);
                }
                int[] nArr3 = this.operate(tmp, 0, 2);
                String str3 = this.getString(nArr3);
                if (nArr3[0] > 0 && nArr3[1] > 0 && nArr3[2] > 0 && !set.contains(str3)) {
                    set.add(str3);
                    q.offer(nArr3);
                }
            }
        }
        return 0;
    }

    private int[] operate(int[] arr, int a, int b) {
        int[] tmp = new int[3];
        if (arr[a] == arr[b]) {
            tmp[0] = arr[0];
            tmp[1] = arr[1];
            tmp[2] = arr[2];
        } else if (arr[a] < arr[b]) {
            tmp[a] = arr[a] + arr[a];
            tmp[b] = arr[b] - arr[a];
            tmp[3 - (a + b)] = arr[3 - (a + b)];
        } else {
            tmp[b] = arr[b] + arr[b];
            tmp[a] = arr[a] - arr[b];
            tmp[3 - (a + b)] = arr[3 - (a + b)];
        }
        return tmp;
    }

    private String getString(int[] arr) {
        return arr[0] + " " + arr[1] + " " + arr[2];
    }
}
