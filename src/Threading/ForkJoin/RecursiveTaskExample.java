package Threading.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


class Fibonacci2 extends RecursiveTask<Integer> {
    int n;
    ForkJoinPool pool;

    public Fibonacci2(int n, ForkJoinPool pool) {
        this.n = n;
        this.pool = pool;
    }

    // similar to run() in threads
    @Override
    public Integer compute(){

        if(n<2){
           return n;
        }
        System.out.println("current task count: "+ this.pool.getQueuedTaskCount());
        Fibonacci2 left = new Fibonacci2(this.n-1, this.pool);
        Fibonacci2 right = new Fibonacci2(this.n-2, this.pool);

        left.fork(); // simlar to start(), creates a new task and submit to thread pool
        right.fork();

        return left.join() + right.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(2); // thread pool with 2 threads

        Fibonacci2 root = new Fibonacci2(10,pool);
        int result = pool.invoke(root); // submit the root task to pool

        // this is blocking and it waits for all the tasks to completed
        System.out.println("result: " + result);

    }
}