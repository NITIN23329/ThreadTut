package lld.questions.parkingLot;

enum BillType {
    HOURLY(10), DAILY(500);
    private int price;

    BillType(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
public class Ticket {
    private static int idCounter = 0;
    private int ticketId;
    private Vehicle vehicle;
    private Spot spot;
    private BillType billType;
    private long entryTime;


    public Ticket(Vehicle vehicle, Spot spot, BillType billType) {
        this.ticketId = ++idCounter;
        this.vehicle = vehicle;
        this.spot = spot;
        this.billType = billType;
        this.entryTime = System.currentTimeMillis();
    }


    public int getTicketId() {
        return ticketId;
    }


    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Spot getSpot() {
        return spot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", vehicle=" + vehicle +
                ", spot=" + spot +
                ", billType=" + billType +
                ", entryTime=" + entryTime +
                '}';
    }
}
