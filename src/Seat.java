public  class Seat {
    private int seatNum;
    private String SeatClass;
    private boolean isAvilable;
    public Seat(int seatNum, String seat_Class) {
        this.seatNum = seatNum;
        this.SeatClass = SeatClass;
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