package designPattern.behavioural;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void addBidder(Bidder bidder);
    void notifyBidder(Bidder bidder, int amount);

}
class AuctionMediator implements Mediator {
    private List<Bidder> bidders ;
    public AuctionMediator() {
        bidders = new ArrayList<>();
    }

    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void notifyBidder(Bidder bidder, int amount) {
        for (Bidder b : bidders) {
            if(!b.equals(bidder)) {
                b.getBidNotification(bidder, amount);
            }
        }
    }
}

interface Bidder {
    void addBid(int amount);
    void getBidNotification(Bidder bidder, int amount);
}

class AuctionBidder implements Bidder {
    private String name;
    private Mediator mediator;
    public AuctionBidder(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public void addBid(int amount) {
        mediator.notifyBidder(this, amount);
    }

    @Override
    public void getBidNotification(Bidder bidder, int amount) {
        System.out.println("Bid " + amount + " from " + bidder +", notification received by : " + name);
    }

}

public class MediatorExample {
    public static void main(String[] args) {
        Mediator auctionMediator = new AuctionMediator();
        Bidder bidder1 = new AuctionBidder("B1", auctionMediator);
        Bidder bidder2 = new AuctionBidder("B2", auctionMediator);
        Bidder bidder3 = new AuctionBidder("B3", auctionMediator);

        auctionMediator.addBidder(bidder1);
        auctionMediator.addBidder(bidder2);
        auctionMediator.addBidder(bidder3);

        bidder1.addBid(100);
        bidder2.addBid(150);
    }
}
