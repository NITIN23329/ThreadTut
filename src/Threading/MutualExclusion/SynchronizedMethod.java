package Threading.MutualExclusion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedMethod implements Runnable{
    int counter;
    // this is critical section, will be accessed by multiple threads
    // by making method / block synchronized, we make sure that block is executed by single thread at a time
    @Override
    public  synchronized void run(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es  = Executors.newFixedThreadPool(2);
        SynchronizedMethod r1 = new SynchronizedMethod();
        for(int i=0;i<10000;i++){
            es.execute(r1);

        }
        if(!es.isTerminated()) {
            es.shutdown();
            es.awaitTermination(5L, TimeUnit.SECONDS);
        }
        System.out.println("value of count: " + r1.counter);

    }


}
