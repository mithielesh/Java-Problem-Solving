public class justifyText {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0, end = 0, wordLen = 0;
        List<String> list = new ArrayList<>();
        for(String word : words) {
            int len = word.length();
            wordLen += len;
            if((wordLen + end - start) > maxWidth) {
                wordLen -= len; 
                builder(list,start,end,words,wordLen,maxWidth,false);
                start = end;
                wordLen = len;
            }
            end++;
        }
        builder(list,start,end,words,wordLen,maxWidth,true);
        return list;
    }
    private void builder(List<String> list, int start, int end, String[] words, int wordLen, int maxWidth, boolean last) {
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - wordLen;
        if(!last) {
            // If the line is not the last line so centre justfied
            // If the spaces are not equal then more towards the left than the right
            int gaps = (end - start - 1 == 0) ? 0 : end - start - 1;
            if(gaps == 0) {
                sb.append(words[start]);
                while(spaces != 0) {
                    sb.append(' ');
                    spaces--;
                }
            }
            else {
                int gapper = spaces / gaps, counter = spaces % gaps;
                for(int i = start; i < end-1; i++) {
                    sb.append(words[i]);
                    int sp = gapper;
                    while(sp > 0) {
                        sb.append(' ');
                        sp--;
                    }
                    if(counter > 0) {
                        sb.append(' ');
                        counter--;
                    }
                }
                sb.append(words[end-1]);
            }
        }
        else {
            // The last line is left justified
            for(int i = start; i < end-1; i++) {
                sb.append(words[i]).append(' ');
                spaces--;
            }
            sb.append(words[end-1]);
            while(spaces > 0) {
                sb.append(' ');
                spaces--;
            }
        }
        list.add(sb.toString());
    }
}