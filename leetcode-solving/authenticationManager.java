class ListNode {
    int time;
    String id;
    ListNode prev;
    ListNode next;

    public ListNode(String id, int ttl) {
        this.time = ttl;
        this.id = id;
        this.prev = null;
        this.next = null;
    }
}
public class authenticationManager {
    HashMap<String, ListNode> map = new HashMap<>();
    ListNode head, tail;
    int updateTime;
    public AuthenticationManager(int timeToLive) {
        head = new ListNode(".", -1) ;
        tail = new ListNode(".", -1);
        setup(head,tail);
        updateTime = timeToLive;
    }

    private void setup(ListNode head, ListNode tail) {
        head.next = tail;
        tail.prev = head;
    }
    
    public void generate(String tokenId, int currentTime) {
        // Just creating the time stamps
        ListNode node = new ListNode(tokenId, currentTime + updateTime);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        map.put(tokenId,node);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId)) {
            return;
        }
        ListNode node = map.get(tokenId);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(tokenId);
        if(node.time > currentTime) {
            generate(tokenId,currentTime);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        ListNode curNode = tail.prev;
        int size = 0;
        while(curNode != head && curNode.time > currentTime) {
            curNode = curNode.prev;
            size++;
        }
        return size;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */