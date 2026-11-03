public class reformatNumber {
    public String reformatPhoneNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int n = number.length();
        for(int i = 0; i < n; i++) {
            char c = number.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        int len = sb.length();
        if(len == 2 || len == 3) {
            return sb.toString();
        }
        int dist = 1;
        if(len % 3 == 1) {
            sb.insert(len-2,'-');
            dist = 3;
        }
        int counter = 0;
        for(int i = 0; i < sb.length()-dist; i++) {
            counter++;
            if(counter == 3) {
                sb.insert(i+1,'-');
                counter = 0;
                i++;
            }
        }
        return sb.toString();
    }
}