package lld.questions.parkingLot;

enum SpotType{
    TWO_WHEELER, FOUR_WHEELER;

}

// we can have two type of spots: 2 wheeler and 4 wheeler(inheritance)
public class Spot {
    private int id;
    private boolean isAvailable;
    private SpotType spotType;

    public Spot(int id, boolean isAvailable, SpotType spotType) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.spotType = spotType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public int getSpotId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", isAvailable=" + isAvailable +
                ", spotType=" + spotType +
                '}';
    }
}
