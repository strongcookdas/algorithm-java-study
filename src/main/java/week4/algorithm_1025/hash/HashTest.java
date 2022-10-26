package week4.algorithm_1025.hash;

public class HashTest {
    public int hash(String key){
        int asciiSum = 0;
        for(int i=0; i<key.length();i++){
            asciiSum += key.charAt(i);
        }
        return asciiSum % 90;
    }

    public static void main(String[] args) {
        HashTest h = new HashTest();
        h.hash("jisukim");
    }
}
