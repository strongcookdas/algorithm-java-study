package week5.algorithm_1102.Eratoste;

import java.util.ArrayList;
import java.util.List;

public class Eratoste {
    List<Integer> list = new ArrayList<>();
    
    public void init(){
        for (int i = 2; i < 51; i++) {
            list.add(i);
        }
    }

    public boolean isPrime(int num){
        for (int i = 2; i*i<=num ; i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }

    public int deleteMultiple(){
        this.init();
        for(int i = 2; i<51; i+=2){
            if(i==2) continue;
            list.remove(Integer.valueOf(i));
        }

        for (int num:
             list) {
            System.out.println(num);
        }
        return list.size();
    }

    public static void main(String[] args) {
        Eratoste e = new Eratoste();
        System.out.println(e.deleteMultiple());
    }
}
