package week4.algorithm_1026.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AthletesTest {
    class Node {
        private String key;
        private int value;

        private int visited;
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public int getVisited() {
            return visited;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setVisited(int visited) {
            this.visited = visited;
        }
    }

    public int hash(String key) {
        int asciSum = 0;
        for (int i = 0; i < key.length(); i++) {
            asciSum += key.charAt(i);
        }
        return asciSum % 10000;
    }

    public void insert(List<Node>[] table, String[] participant, String[] completion) {
        for (String tmp : participant) {
            if(table[this.hash(tmp)]==null){
                table[this.hash(tmp)]=new ArrayList<>();
            }
            table[this.hash(tmp)].add(new Node(tmp, 0));
        }

        for (String tmp : completion){
            List<Node> list = table[this.hash(tmp)];
            for (Node node :
                    list) {
                if (tmp.equals(node.getKey())&&node.getVisited()==0) {
                    node.setValue(1);
                    node.setVisited(1);
                    break;
                }
            }
        }
    }

    public Node search(List<Node>[] table, String key) {
        List<Node> list = table[this.hash(key)];
        for (Node tmp :
                list) {
            if (key.equals(tmp.getKey())) {
                return tmp;
            }
        }
        return null;
    }


    public void print(List<Node>[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                System.out.print(i+"번째 : ");
                for (int j = 0; j < arr[i].size(); j++) {
                    System.out.print(arr[i].get(j).getKey()+" "+arr[i].get(j).getValue());
                }
                System.out.println();
            }
        }
    }


    public String solution(String[] participant, String[] completion) {
        List<Node>[] table = new ArrayList[10000];
        this.insert(table,participant,completion);
        this.print(table);
        for(String key:participant){
            Node tmp = this.search(table,key);
            if(tmp.getValue()==0){
                return tmp.getKey();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        AthletesTest a = new AthletesTest();
        String[] participant ={"mislav", "stanko", "mislav", "ana"};
        String[] completion ={"stanko", "ana", "mislav"};
        System.out.println(a.solution(participant,completion));
    }


}
