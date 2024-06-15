package algorithm.dfs.programmers;

/**
 * 순열 구하는 방식 활용
 */

import java.util.*;

class Ticket{
    String to;
    boolean visited = false;
    public Ticket(String to){
        this.to = to;
    }
}
public class 여행경로 {
    String[] path;
    boolean flag = false;

    public void DFS(int L, HashMap<String,List<Ticket>> map, String from){
        if(flag) return;

        path[L] = from;

        if (L == path.length - 1) {
            flag = true;
            return;
        }
        if(!map.containsKey(from)) return;

        List<Ticket> toList = map.get(from);
        for(int i = 0; i<toList.size(); i++){
            if(!toList.get(i).visited){
                toList.get(i).visited = true;
                DFS(L+1, map, toList.get(i).to);
                if (flag) return;
                toList.get(i).visited = false;
            }
        }

    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets, Comparator.comparing((String[] a) -> a[0]).thenComparing(a -> a[1]));

        HashMap<String,List<Ticket>> ticketsMap = new HashMap<>();

        for(String[] ticket : tickets){
            ticketsMap.putIfAbsent(ticket[0], new LinkedList<>());
            ticketsMap.get(ticket[0]).add(new Ticket(ticket[1]));
        }

        path = new String[tickets.length+1];

        DFS(0, ticketsMap, "ICN");
        return path;
    }
}
