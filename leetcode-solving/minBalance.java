public class minBalance {
    public int minInsertions(String s) {
        // The open means I need to find 2 to close it, the close means that I have had some to close what I can
        boolean encountered = false;
        int needed = 0, insertions = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                if(encountered) {
                    if(needed > 0 && needed % 2 == 1) {
                        insertions++;
                        needed--;
                    }
                    else if(needed < 0) {
                        needed = 0-needed;
                        if(needed % 2 == 1) {
                            insertions += 2;
                        }
                        insertions += needed/2;
                        needed = 0;
                    }
                    encountered = false;
                }
                needed += 2;
            }
            else {
                encountered = true;
                needed--;
            }
        }
        if(needed < 0) {
            needed = 0-needed;
            if(needed % 2 == 1) {
                insertions += 2;
            }
            insertions += needed/2;
            needed = 0;
        }
        return needed + insertions;
    }
}