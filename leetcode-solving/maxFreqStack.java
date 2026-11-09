public class maxFreqStack {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Deque<Integer>> maxStack;
    int maxFreq;
    public maxFreqStack() {
        map = new HashMap<>();
        maxStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val,0)+1);
        if(map.get(val) > maxFreq) {
            maxFreq++;
            maxStack.put(maxFreq, new ArrayDeque<Integer>());
        }
        maxStack.get(map.get(val)).push(val);
    }
    
    public int pop() {
        if(maxStack.get(maxFreq).isEmpty()) {
            maxStack.remove(maxFreq);
            maxFreq--;
        }
        int val =  maxStack.get(maxFreq).pop();
        int freq = map.get(val) - 1;
        if(freq == 0) {
            map.remove(val);
        }
        else {
            map.replace(val,freq);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */