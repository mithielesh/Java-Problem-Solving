public class dota2senate {
    public String predictPartyVictory(String senate) {
        int rCount = 0, dCount = 0;
        for(char c : senate.toCharArray()) {
            if(c == 'R') {
                rCount++;
            }
            else {
                dCount++;
            }
        }
        if(rCount == 0) {
            return "Dire";
        }
        if(dCount == 0) {
            return "Radiant";
        }
        int n = senate.length(), rBan = 0, dBan = 0;
        rCount = 0; dCount = 0;
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if(c == 'R') {
                if(dBan > 0) {
                    dBan--;
                }
                else {
                    q.offer(c);
                    rBan++; rCount++;
                }
            }
            else {
                if(rBan > 0) {
                    rBan--;
                }
                else {
                    q.offer(c);
                    dBan++; dCount++;
                }
            }
        }
        while(rCount > 0 && dCount > 0) {
            char c = q.poll();
            if(c == 'R') {
                rCount--;
                if(dBan > 0) {
                    dBan--;
                }
                else {
                    q.offer(c);
                    rBan++; rCount++;
                }
            }
            else {
                dCount--;
                if(rBan > 0) {
                    rBan--;
                }
                else {
                    q.offer(c);
                    dBan++; dCount++;
                }
            }
        }
        if(rCount > 0) {
            return "Radiant";
        }
        return "Dire";
    }
}