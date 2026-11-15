public class removeSubstringOccurrence {
    public String removeOccurrences(String s, String part) {
        // Brute force
        char[] arr = new char[s.length()];
        int subLen = part.length(), ptr = 0;
        char last = part.charAt(subLen-1);
        for(char c : s.toCharArray()) {
            if(c == last && ptr >= subLen-1) {
                int index = subLen - 2, mover = ptr-1;
                while(index >= 0 && arr[mover] == part.charAt(index)) {
                    mover--;
                    index--;
                }
                if(index != -1) {
                    arr[ptr] = c;
                    ptr++;
                }
                else {
                    ptr = mover+1;
                }
            }
            else {
                arr[ptr] = c;
                ptr++;
            }
        }
        return String.valueOf(arr,0,ptr);
    }
}