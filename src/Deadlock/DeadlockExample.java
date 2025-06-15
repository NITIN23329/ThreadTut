package Deadlock;

public class DeadlockExample {
    // File: DeadlockDemo.java
        private static final Object LOCK_A = new Object();
        private static final Object LOCK_B = new Object();

        public static void main(String[] args) {
            Thread t1 = new Thread(() -> {
                synchronized (LOCK_A) {
                    System.out.println("T1 locked A");
                    sleep(100);
                    synchronized (LOCK_B) {
                        System.out.println("T1 locked B");
                    }
                }
            });

            Thread t2 = new Thread(() -> {
                synchronized (LOCK_B) {
                    System.out.println("T2 locked B");
                    sleep(100);
                    synchronized (LOCK_A) {
                        System.out.println("T2 locked A");
                    }
                }
            });

            t1.start();
            t2.start();
        }

        private static void sleep(long ms) {
            try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
        }

}
