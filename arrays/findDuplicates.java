import java.util.*;

class CharBucket {
    char letter;
    int freq;
    public CharBucket(char letter, int freq) {
        this.letter = letter;
        this.freq = freq;
    }
}

public class findDuplicates {
    private static String frequencySort(String s) {
        // Count the frequencies of the characters
        int[] freqArr = new int[256];
        for(char c : s.toCharArray()) {
            freqArr[c]++;
        }
        
        // Add them to the priority queue
        PriorityQueue<CharBucket> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int i = 0; i < 256; i++) {
            if(freqArr[i] > 0) {
                CharBucket bucket = new CharBucket((char)(i), freqArr[i]);
                maxHeap.offer(bucket);
            }
        }
        // Now remove the elements from the max heap and then create the string
        StringBuilder str = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            CharBucket bucket = maxHeap.poll();
            char c = bucket.letter;
            for(int i = 0; i < bucket.freq; i++) {
                str.append(c);
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(frequencySort(s));
        sc.close();
    }
}
