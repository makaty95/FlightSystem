public class Seat {
    private int seatNum;
    public String SeatClass;

    public Seat() {

    }

    private boolean isAvilable;

    public Seat(int seatNum, String seatClass) {
        this.seatNum = seatNum;
        this.SeatClass = seatClass;
    }

    public int getSeat_Num() {
        return seatNum;
    }

    public String getSeatClass() {
        return SeatClass;
    }

    public void setSeatClass(String seatClass) {
        this.SeatClass = SeatClass;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public boolean isAvilable() {
        return isAvilable;
    }

    public void setAvilable(boolean avilable) {
        isAvilable = avilable;
    }
}