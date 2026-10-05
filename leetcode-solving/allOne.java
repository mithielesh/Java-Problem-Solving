class Node {
    int freq;
    HashSet<String> set;
    Node prev;
    Node next;

    public Node(int freq) {
        this.freq = freq;
        this.set = new HashSet<>();
        this.prev = null;
        this.next = null;
    }
    public Node(int freq, HashSet<String> set) {
        this.freq = freq;
        this.set = set;
        this.prev = null;
        this.next = null;
    }
}
public class allOne {
    Node head, tail;
    HashMap<String,Node> map;
    public AllOne() {
        head = new Node(0,null);
        tail = new Node(1,null);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public void inc(String key) {
        Node curNode = head;
        if(map.containsKey(key)) {
           curNode = map.get(key);
        }
        int freq = curNode.freq + 1;
        if(curNode.next == tail || curNode.next.freq != freq) {
            Node node = new Node(freq);
            curNode.next.prev = node;
            node.next = curNode.next;
            node.prev = curNode;
            curNode.next = node;
        }
        if(curNode != head) {
            curNode.set.remove(key);
            if(curNode.set.size() == 0) {
               curNode.prev.next = curNode.next;
                curNode.next.prev = curNode.prev;
            }
        }
        curNode = curNode.next;
        curNode.set.add(key);
        map.put(key,curNode);
    }
    
    public void dec(String key) {
        Node curNode = map.get(key);
        curNode.set.remove(key);
        int freq = curNode.freq - 1;
        if(freq == 0 && curNode.prev == head) {
            map.remove(key);
        }
        else if(curNode.prev.freq == freq) {
            curNode.prev.set.add(key);
            map.replace(key,curNode.prev);
        }
        else {
            Node node = new Node(freq);
            curNode.prev.next = node;
            node.next = curNode;
            node.prev = curNode.prev;
            curNode.prev = node;
            map.replace(key,node);
            node.set.add(key);
        }
        if(curNode.set.size() == 0) {
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
        }
    }
    
    public String getMaxKey() {
        if(tail.prev == head) {
            return "";
        }
        return tail.prev.set.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == tail) {
            return "";
        }
        return head.next.set.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */