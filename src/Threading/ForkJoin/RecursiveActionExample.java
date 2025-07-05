package Threading.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample {
}


class Fibonacci extends RecursiveAction {
    int n;
    int result;
    ForkJoinPool pool;

    public Fibonacci(int n, ForkJoinPool pool) {
        this.n = n;
        result = 0;
        this.pool = pool;
    }

    // similar to run() in threads
    @Override
    public void compute(){

        if(n<2){
            this.result = n;
            return;
        }
        System.out.println("current task count: "+ this.pool.getQueuedTaskCount());
        Fibonacci left = new Fibonacci(this.n-1, this.pool);
        Fibonacci right = new Fibonacci(this.n-2, this.pool);

        left.fork(); // simlar to start(), creates a new task and submit to thread pool
        right.fork();

        left.join(); // wait for both tasks to run
        right.join();
        this.result = left.result + right.result;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(2); // thread pool with 2 threads

        Fibonacci root = new Fibonacci(10,pool);
        pool.invoke(root); // submit the root task to pool

        // this is blocking and it waits for all the tasks to completed
        System.out.println("result: " + root.result);

    }
}