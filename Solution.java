import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        List <Integer> list1 = new ArrayList<>(arr);
        List <Integer> list2 = new ArrayList<>(arr);
        Collections.sort(list1);
        Collections.sort(list2);
        Collections.reverse(list2);
        List <Integer> ans1 = new ArrayList<>();
        List <Integer> ans2 = new ArrayList<>();
        int fCount=0, bCount=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==list1.get(i)){
                fCount++;
            }else{
                ans1.add(i+1);
            }
            if(arr.get(i)==list2.get(i)){
                bCount++;
                ans2.add(i+1);
            }
        }
        if(arr.size()==2){
            if(fCount==0){
                System.out.println("yes\nswap 1 2");
                return;
            }
            System.out.println("no");
            return;
        }
        int total = fCount+bCount;
        if(total==0){
            System.out.println("no");
        }
        else if(ans1.size()==2 && ans1.get(0)!=1 && ans1.get(1)!=arr.size()){
            System.out.println("yes\nswap "+ans1.get(0)+" "+ans1.get(1));
        }
        else if(total==arr.size()){
            System.out.println("yes\nreverse "+ans2.get(0)+" "+ans2.get(ans2.size()-1));
        }
        else{
            System.out.println("no");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
