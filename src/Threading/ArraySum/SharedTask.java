package Threading.ArraySum;

class Task implements Runnable {
    private int count = 1;

    @Override
    public void run() {
        while (true) {
            // use synchronized block if you want to allow one thread to enter that block at a time
            synchronized (this) {
                if (count > 10) break;
                System.out.println(Thread.currentThread().getName() + " - Count: " + count);
                count++;
            }

            try {
                Thread.sleep(100); // Slow down for visibility
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


public class SharedTask {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task(); // Only ONE Runnable instance

        System.out.println(Thread.currentThread().getName() +" before creating thread");
        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");

        System.out.println(Thread.currentThread().getName() +" before starting thread");

        t1.start();
        t2.start();

        t1.join();t2.join();
        System.out.println(Thread.currentThread().getName() +" after completing thread");
    }
}
