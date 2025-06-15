package ExecutorService;

import ArraySum.ArraySum;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int[] arr = {1,2,3,4,5,6};
        int n = arr.length;

        ArraySum left = new ArraySum(arr,0,n/2 - 1);
        ArraySum right = new ArraySum(arr,n/2,n - 1);
        executorService.execute(left);
        executorService.execute(right);

        if(!executorService.isTerminated()){
            executorService.shutdown();
            // blocks untill all tasks completed execution after a shut down request is done
            executorService.awaitTermination(5L, TimeUnit.SECONDS);
        }


        int result = left.getSum() + right.getSum();
        System.out.println(result);

    }
}
