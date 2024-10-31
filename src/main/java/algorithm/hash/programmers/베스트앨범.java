package algorithm.hash.programmers;

import java.util.*;

class 베스트앨범 {
    static class Music{
        int idx;
        int count;
        public Music(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }

    static class Genre{
        int total = 0;
        LinkedList<Music> list = new LinkedList<>();
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Genre> map = new HashMap<>();

        for(int i = 0; i<genres.length; i++){
            String key = genres[i];
            int count = plays[i];
            Genre genre = map.getOrDefault(key,new Genre());
            genre.total += count;
            map.put(key,genre);
            genre.list.add(new Music(i,count));
        }


        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a,b)->map.get(b).total-map.get(a).total);

        List<Integer> tmpList = new ArrayList<>();
        for(String key : keySet){
            Genre value = map.get(key);
            value.list.sort((a,b)->{
                if(a.count==b.count){
                    return a.idx - b.idx;
                }else{
                    return b.count - a.count;
                }
            });

            tmpList.add(value.list.get(0).idx);
            if(value.list.size()>1){
                tmpList.add(value.list.get(1).idx);
            }
        }

        int[] answer = new int[tmpList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = tmpList.get(i);
        }

        return answer;
    }
}