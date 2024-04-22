package algorithm.greedy.inflearn;
/*
1. 이중 for문으로 풀면 시간 초과
2. 키순으로 정렬 후 내 앞사람보다 몸무게가 크면 그 사람 카운트
3. 몸무게가 앞사람보다 낮으면 키와 몸무게가 자신보다 큰 사람이 있다는 의미
4. 1개의 for문으로 풀어야 한다. (전 방법으로 푼 것은 원래 시간초과가 났어야 했다.)
 */

import java.util.*;

class Player implements Comparable<Player> {
    int height;
    int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        if (this.height == o.height) return o.weight - this.weight;
        else return o.height - this.height;
    }
}

public class 씨름선수 {
    static int n, answer = 1;
    static ArrayList<Player> players = new ArrayList<>();

    public static void solution() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max = players.get(i).weight;
                continue;
            }
            if (players.get(i).weight > max) {
                max = players.get(i).weight;
                answer++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        for (int i = 0; i < n; i++) players.add(new Player(kb.nextInt(), kb.nextInt()));
        Collections.sort(players);
        solution();
        System.out.println(answer);
    }
}
