public class BoardPass {
    public int seatNumber;
    public int zoneNumber;
    public  String threadName;

    BoardPass(){}
    BoardPass(int seat, int zoneNumber, String threadName ){
        this.seatNumber = seat;
        this.zoneNumber = zoneNumber;
        this.threadName = threadName;
    }
}
