// File: NotVolatileExample.java
package MutualExclusion;
class NotVolatileExample {

//
//    static class MyTask implements Runnable {
//         boolean running = true;
//
//        public void run() {
//            System.out.println("Thread started");
//            while (running) {
//                // Busy wait
//            }
//            System.out.println("Thread stopped");
//        }
//
//        public void stop() {
//            running = false;
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        MyTask task = new MyTask();
//        Thread t = new Thread(task);
//        t.start();
//
//        Thread.sleep(1000); // Let the thread run for a bit
//
//        System.out.println("Stopping thread...");
//        task.stop(); // Set flag to false — but thread may never see it!
//
//        t.join(); // Wait forever if thread never exits
//        System.out.println("Main finished");
//    }




    // File: VolatileExample.java
        static class MyTask implements Runnable {
            volatile boolean running = true;

            public void run() {
                System.out.println("Thread started");
                while (running) {
                    // Busy wait
                }
                System.out.println("Thread stopped");
            }

            public void stop() {
                running = false;
            }
        }

        public static void main(String[] args) throws InterruptedException {
            MyTask task = new MyTask();
            Thread t = new Thread(task);
            t.start();

            Thread.sleep(1000); // Let the thread run for a bit

            System.out.println("Stopping thread...");
            task.stop(); // Now the thread will always see this change

            t.join(); // Will not hang anymore
            System.out.println("Main finished");
        }
    }

