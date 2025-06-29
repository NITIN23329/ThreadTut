package designPattern.behavioural;

import java.util.ArrayList;
import java.util.List;

// publisher interface, any publisher must have add remove and notify subscriber
interface Publisher {
    void notifyAll(String message);
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);

}
// subscriber interface, any subscriber must define what to do with new updates
interface Subscriber {
    void update(String message);
}
// concrete publisher, it has list of subscribers
class YoutubeChannel implements Publisher {

    List<Subscriber> subscriberList;
    public  YoutubeChannel() {
        subscriberList = new ArrayList<>();
    }
    @Override
    public void addSubscriber(Subscriber s){
        subscriberList.add(s);
    }
    @Override
    public void removeSubscriber(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }
    @Override
    public void notifyAll(String videoName){
        for(Subscriber subscriber : subscriberList){
            subscriber.update(videoName);
        }
    }
}
// concrete subscribersX$
class BasicSubscriber implements Subscriber {
    @Override
    public void update(String message) {
        System.out.println("Video with ads: "+message);
    }
}
class PremiumSubscriber implements Subscriber {
    @Override
    public void update(String message) {
        System.out.println("Video without ads: "+message);
    }
}

public class ObserverExample {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        BasicSubscriber basicSubscriber = new BasicSubscriber();
        PremiumSubscriber premiumSubscriber = new PremiumSubscriber();
        youtubeChannel.addSubscriber(premiumSubscriber);
        youtubeChannel.addSubscriber(basicSubscriber);

        youtubeChannel.notifyAll("GTA V free download");
    }
}
