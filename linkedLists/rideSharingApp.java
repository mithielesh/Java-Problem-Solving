import java.util.*;

class RiderNode {
    int id;
    RiderNode prev;
    RiderNode next;
    public RiderNode(int id) {
        this.id = id;
        this.prev = null;
        this.next = null;
    }
}
class DriverNode {
    int id;
    DriverNode prev;
    DriverNode next;
    public DriverNode(int id) {
        this.id = id;
        this.prev = null;
        this.next = null;
    }
}

class RideSharingSystem {

    DriverNode dHead, dTail;
    RiderNode rHead, rTail;
    Map<Integer, RiderNode> requests = new HashMap<>();


    public RideSharingSystem() {
        // Initialize the nodes
        dHead = new DriverNode(-1);
        dTail = new DriverNode(-1);
        rHead = new RiderNode(-1);
        rTail = new RiderNode(-1);
        // Make the connections
        dHead.next = dTail;
        dTail.prev = dHead;
        rHead.next = rTail;
        rTail.prev = rHead;
    }
    
    public void addRider(int riderId) {
        RiderNode rider = new RiderNode(riderId);
        rider.next = rHead.next;
        rider.prev = rHead;
        rHead.next.prev = rider;
        rHead.next = rider;
        requests.put(riderId,rider);
    }
    
    public void addDriver(int driverId) {
        DriverNode driver = new DriverNode(driverId);
        driver.next = dHead.next;
        driver.prev = dHead;
        dHead.next.prev = driver;
        dHead.next = driver;
    }
    
    public int[] matchDriverWithRider() {
        if(rTail.prev == rHead || dTail.prev == dHead) {
            return new int[]{-1,-1};
        }

        RiderNode rider = rTail.prev;
        rider.prev.next = rider.next;
        rider.next.prev = rider.prev;
        requests.remove(rider.id);

        DriverNode driver = dTail.prev;
        driver.prev.next = driver.next;
        driver.next.prev = driver.prev;
        return new int[]{driver.id,rider.id};
    }
    
    public void cancelRider(int riderId) {
        if(!requests.containsKey(riderId)) {
            return;
        }
        RiderNode cancelNode = requests.get(riderId);
        cancelNode.prev.next = cancelNode.next;
        cancelNode.next.prev = cancelNode.prev;
        requests.remove(riderId);
    }
}

public class rideSharingApp {
    public  static void main(String[] args) {
        RideSharingSystem r = new RideSharingSystem();
        r.addRider(3);
        r.addDriver(2);
        r.addRider(1);
        int[] match = r.matchDriverWithRider();
        System.out.println(match[0] + " " + match[1]);
        r.cancelRider(3);
        r.addDriver(4);
        match = r.matchDriverWithRider();
        System.out.println(match[0] + " " + match[1]);
    }
}