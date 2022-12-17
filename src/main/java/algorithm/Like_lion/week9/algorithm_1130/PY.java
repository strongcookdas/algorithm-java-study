package algorithm.Like_lion.week9.algorithm_1130;

public class PY {
    public boolean solution(String s){
        int p = 0;
        int y = 0;
        String str = s.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'P') p++;
            else if( c == 'Y') y++;
        }

        if(p==y) return true;
        else return false;
    }

    public static void main(String[] args) {
        boolean result = new PY().solution("Pyy");
        System.out.println(result);
    }
}
