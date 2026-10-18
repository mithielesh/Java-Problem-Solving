public class evaluateBracketPairStrings {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> lookup = new HashMap<>();
        for(List<String> mapping : knowledge) {
            lookup.put(mapping.get(0), mapping.get(1));
        }
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c != '(') {
                sb.append(c);
            }
            else {
                i++;
                int start = i;
                while(s.charAt(i) != ')') {
                    i++;
                }
                String sub = s.substring(start,i);
                if(lookup.containsKey(sub)) {
                    sb.append(lookup.get(sub));
                }
                else {
                    sb.append('?');
                }
            }
        }
        return sb.toString();
    }
}