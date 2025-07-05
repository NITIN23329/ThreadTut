package Threading.Monitor;

public class MonitorExample {

    static class DataBox {
        private int data;
        private boolean hasData = false;

        public synchronized void produce(int value) {
            while (hasData) {
                try { wait(); } catch (InterruptedException e) {}
            }
            this.data = value;
            hasData = true;
            System.out.println("Produced: " + value);
            notify(); // wake up consumer
        }

        public synchronized int consume() {
            while (!hasData) {
                try { wait(); } catch (InterruptedException e) {}
            }
            hasData = false;
            System.out.println("Consumed: " + data);
            notify(); // wake up producer
            return data;
        }
    }

    static class Producer extends Thread {
        DataBox box;

        Producer(DataBox box) {
            this.box = box;
        }

        public void run() {
            for (int i = 1; i <= 10; i++) {
                box.produce(i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }

    static class Consumer extends Thread {
        DataBox box;

        Consumer(DataBox box) {
            this.box = box;
        }

        public void run() {
            for (int i = 1; i <= 10; i++) {
                box.consume();
                try { Thread.sleep(800); } catch (InterruptedException e) {}
            }
        }
    }


    public static void main(String[] args) {
        DataBox box = new DataBox();
        new Producer(box).start();
        new Consumer(box).start();
    }



}
