import java.util.*;
public class frontBackMiddleQueue {
    List<Integer> list;
    public FrontMiddleBackQueue() {
        list = new LinkedList<>();
    }
    
    public void pushFront(int n) {
        list.addFirst(n);
    }
    
    public void pushMiddle(int n) {
        int size = list.size();
        if(size == 0) {
            list.add(n);
        }
        else {
            int mid = (size - 1) / 2;
            if(size % 2 == 0) {
                list.add(mid+1,n);
            }
            else {
                list.add(mid,n);
            }
        }
    }
    
    public void pushBack(int n) {
        list.addLast(n);
    }
    
    public int popFront() {
        if(list.size() == 0) {
            return -1;
        }
        return list.removeFirst();
    }
    
    public int popMiddle() {
        if(list.size() == 0) {
            return -1;
        }
        int mid = (list.size() - 1) / 2;
        return list.remove(mid);
    }
    
    public int popBack() {
        if(list.size() == 0) {
            return -1;
        }
        return list.removeLast();
    }

    public static void main(String[] args) {
        list = new LinkedList<>();
    }
}
