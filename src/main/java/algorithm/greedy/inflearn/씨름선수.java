package algorithm.greedy.inflearn;

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
    static int n, answer;
    static ArrayList<Player> players = new ArrayList<>();

    public static void solution() {
        for (Player p1 : players) {
            for (Player p2 : players) {
                if (p1.height < p2.height && p1.weight < p2.weight) {
                    answer--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        answer = n;
        for (int i = 0; i < n; i++) players.add(new Player(kb.nextInt(), kb.nextInt()));
        Collections.sort(players);
        solution();
        System.out.println(answer);
    }
}
