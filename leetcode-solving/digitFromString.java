public class digitFromString {
    public String originalDigits(String s) {
        int[] hashTable = new int[26];
        for(char c : s.toCharArray()) {
            hashTable[c-'a']++;
        }
        int[] freqArr = new int[10];
        if(hashTable['z'-'a'] != 0) {
            int count = hashTable['z'-'a'], counter = 0;
            while(counter < count) {
                freqArr[0]++;
                counter++;
            }
            hashTable['z'-'a']-=count;
            hashTable['e'-'a']-=count;
            hashTable['r'-'a']-=count;
            hashTable['o'-'a']-=count;
        }
        if(hashTable['w'-'a'] != 0) {
            int count = hashTable['w'-'a'], counter = 0;
            while(counter < count) {
                freqArr[2]++;
                counter++;
            }
            hashTable['t'-'a']-=count;
            hashTable['w'-'a']-=count;
            hashTable['o'-'a']-=count;
        }
        if(hashTable['u'-'a'] != 0) {
            int count = hashTable['u'-'a'], counter = 0;
            while(counter < count) {
                freqArr[4]++;
                counter++;
            }
            hashTable['f'-'a']-=count;
            hashTable['o'-'a']-=count;
            hashTable['u'-'a']-=count;
            hashTable['r'-'a']-=count;
        }
        if(hashTable['x'-'a'] != 0) {
            int count = hashTable['x'-'a'], counter = 0;
            while(counter < count) {
                freqArr[6]++;
                counter++;
            }
            hashTable['s'-'a']-=count;
            hashTable['i'-'a']-=count;
            hashTable['x'-'a']-=count;
        }
        if(hashTable['g'-'a'] != 0) {
            int count = hashTable['g'-'a'], counter = 0;
            while(counter < count) {
                freqArr[8]++;
                counter++;
            }
            hashTable['e'-'a']-=count;
            hashTable['i'-'a']-=count;
            hashTable['g'-'a']-=count;
            hashTable['h'-'a']-=count;
            hashTable['t'-'a']-=count;
        }
        if(hashTable['o'-'a'] != 0 && hashTable['e'-'a'] != 0) {
            int count = hashTable['o'-'a'], counter = 0;
            while(counter < count) {
                freqArr[1]++;
                counter++;
            }
            hashTable['o'-'a']-=count;
            hashTable['n'-'a']-=count;
            hashTable['e'-'a']-=count;
        }
        if(hashTable['e'-'a'] >= 2 && hashTable['t'-'a'] != 0) {
            int count = hashTable['t'-'a'], counter = 0;
            while(counter < count) {
                freqArr[3]++;
                counter++;
            }
            hashTable['t'-'a']-=count;
            hashTable['h'-'a']-=count;
            hashTable['r'-'a']-=count;
            hashTable['e'-'a']-=2*count;
        }
        if(hashTable['f'-'a'] != 0 && hashTable['v'-'a'] != 0) {
            int count = hashTable['f'-'a'], counter = 0;
            while(counter < count) {
                freqArr[5]++;
                counter++;
            }
            hashTable['f'-'a']-=count;
            hashTable['i'-'a']-=count;
            hashTable['v'-'a']-=count;
            hashTable['e'-'a']-=count;
        }
        if(hashTable['s'-'a'] != 0 && hashTable['v'-'a'] != 0) {
            int count = hashTable['s'-'a'], counter = 0;
            while(counter < count) {
                freqArr[7]++;
                counter++;
            }
            hashTable['s'-'a']-=count;
            hashTable['e'-'a']-=2*count;
            hashTable['v'-'a']-=count;
            hashTable['n'-'a']-=count;
        }
        if(hashTable['n'-'a'] >= 2) {
            int count = hashTable['i'-'a'], counter = 0;
            while(counter < count) {
                freqArr[9]++;
                counter++;
            }
            hashTable['n'-'a']-=2*count;
            hashTable['e'-'a']-=count;
            hashTable['i'-'a']-=count;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            int count = freqArr[i];
            while(count != 0) {
                sb.append(i);
                count--;
            }
        }
        return sb.toString();
    }
}