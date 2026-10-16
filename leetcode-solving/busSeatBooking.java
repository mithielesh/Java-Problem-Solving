class SeatStatus {
    boolean booked;
    int time;
    public SeatStatus() {
        this.booked = false;
        this.time = 0;
    }
}
public class busSeatBooking {
    int totalBooked;
    int totalTime;
    SeatStatus[][] bus;
    public BusBooking(int n) {
        bus = new SeatStatus[n][4];
        totalBooked = 0;
        totalTime = 0;
    }
    
    // This will be the most heavy lifting function in the program
    public void toggle(String seatDetail) {
        int rowNo = Integer.parseInt(seatDetail.substring(1,seatDetail.length())) - 1;
        char seat = seatDetail.charAt(0);
        int seatNo = -1;
        if(seat == 'A') seatNo = 0;
        else if(seat == 'B') seatNo = 1;
        else if(seat == 'C') seatNo = 2;
        else seatNo = 3;
        SeatStatus ss = bus[rowNo][seatNo];
        if(ss == null) {
            ss = new SeatStatus();
            bus[rowNo][seatNo] = ss;
        }
        if(ss.booked) {
            totalTime -= ss.time;
            ss.booked = false;
            totalBooked--;
        }
        else {
            if(seatNo == 0) {
                if(bus[rowNo][1] == null || !bus[rowNo][1].booked) {
                    ss.time = 1;
                }
                else {
                    ss.time = 3;
                }
            }
            else if(seatNo == 3) {
                if(bus[rowNo][2] == null || !bus[rowNo][2].booked) {
                    ss.time = 1;
                }
                else {
                    ss.time = 3;
                }
            }
            else {
                ss.time = 1;
            }
            totalBooked++;
            totalTime += ss.time;
            ss.booked = true;   
        }
    }
    
    public int getTotalTime() {
        return totalTime;
    }
    
    public int getMinTime() {
        return totalBooked;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */