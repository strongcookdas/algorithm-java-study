package algorithm.dynamic.inflearn;

import java.util.*;

class Brick implements Comparable<Brick>{
    int width;
    int height;
    int weight;

    public Brick(int width, int height, int weight){
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.width - this.width;
    }
}
public class 가장높은탑쌓기 {
    static int[] dy;

    public static int solution(ArrayList<Brick> list){
        int answer = 0;
        Collections.sort(list);
        dy[0] = list.get(0).height;
        answer = dy[0];
        for(int i =1; i<list.size(); i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(list.get(i).weight<list.get(j).weight && dy[j]>max) max = dy[j];
            }
            dy[i] = max + list.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n];
        ArrayList<Brick> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(new Brick(kb.nextInt(),kb.nextInt(),kb.nextInt()));
        System.out.println(solution(list));
    }
}
