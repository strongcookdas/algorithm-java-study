package algorithm.greedy.inflearn;
// 키가 큰 순서로 정렬
// 키가 같다면 몸무게가 많이 나가는 순으로 정렬
// FOR로 순회하면서 몸무게의 MAX값을 변경해가면서 MAX값보다 몸무게 많이 나가면 COUNT
// 몸무게로 결정하는 이유 키 순으로 정렬되어 있기 때문
// O(n)으로 해결

import java.util.*;

public class 씨름선수 {
    static class Player {
        int height;
        int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        Player[] arr = new Player[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Player(kb.nextInt(), kb.nextInt());
        }

        씨름선수 main = new 씨름선수();
        System.out.println(main.solution(arr));
    }

    private int solution(Player[] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a.height == b.height) {
                return b.weight - a.weight;
            }
            return b.height - a.height;
        });
        int weightMax = Integer.MIN_VALUE;
        int count = 0;
        for (Player p : arr) {
            if (p.weight >= weightMax) {
                count++;
                weightMax = p.weight;
            }
        }
        return count;
    }
}
