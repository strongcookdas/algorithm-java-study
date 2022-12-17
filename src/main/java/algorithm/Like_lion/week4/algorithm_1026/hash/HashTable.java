package algorithm.Like_lion.week4.algorithm_1026.hash;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    class Node{
        private String key;
        private Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
    List<Node>[] table = new ArrayList[1000];
    public int hash(String key){
        int asciiSum = 0;
        for(int i=0; i<key.length();i++){
            asciiSum += key.charAt(i);
        }
        return asciiSum % 1000;
    }

    public void insert(String key, Integer value){
        //List
        int hashIdx = hash(key);
        if(this.table[hashIdx]==null){
            this.table[hashIdx]= new ArrayList<>();
        }
        this.table[hashIdx].add(new Node(key,value));
    }

    public Integer search(String key){
        List<Node> nodes = this.table[hash(key)];
        for(Node node : nodes){
            if(key.equals(node.getKey())){
                return node.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable h = new HashTable();
        h.insert("Yoonseo", 1);
        h.insert("Seoyoon", 2);

        if(h.search("Yoonseo")==1){
            System.out.println("테스트 성공");
        }else {
            System.out.println("테스트 실패");
        }
    }
}
