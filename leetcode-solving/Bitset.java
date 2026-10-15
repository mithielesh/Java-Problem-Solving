public class Bitset {
    char[] bits;
    int onesCount, flipped;
    public Bitset(int size) {
        bits = new char[size];
        for(int i = 0; i < size; i++) {
            bits[i] = '0';
        }
        onesCount = 0;
        flipped = 0;
    }
    
    public void fix(int idx) {
        if(flipped == 0) {
            if(bits[idx] == '1') {
                return;
            }
            bits[idx] = '1';
            onesCount++;
        }
        else {
            if(bits[idx] == '0') {
                return;
            }
            bits[idx] = '0';
            onesCount++;
        }
    }
    
    public void unfix(int idx) {
        if(flipped == 0) {
            if(bits[idx] == '0') {
                return;
            }
            bits[idx] = '0';
            onesCount--;
        }
        else {
            if(bits[idx] == '1') {
                return;
            }
            bits[idx] = '1';
            onesCount--;
        }
    }
    
    public void flip() {
        flipped ^= 1;
        onesCount = bits.length - onesCount;
    }
    
    public boolean all() {
        return onesCount == bits.length;
    }
    
    public boolean one() {
        return onesCount > 0;
    }
    
    public int count() {
        return onesCount;
    }
    
    public String toString() {
        if(flipped == 1) {
            int size = bits.length;
            for(int i = 0; i < size; i++) {
                if(bits[i] == '0') {
                    bits[i] = '1';
                }
                else {
                    bits[i] = '0';
                }
            }
            flipped = 0;
        }
        return String.valueOf(bits);
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */