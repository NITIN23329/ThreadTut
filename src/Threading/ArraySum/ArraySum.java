package Threading.ArraySum;

import java.util.Arrays;

// step 1: implement runnable interface
public class ArraySum implements Runnable {
    int[] arr;
    int low, high;
    int sum;

    public ArraySum(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
        sum = 0;
    }


    // step2: implement run()
    @Override
    public void run() {
        System.out.println("running run() method"+ " low: " + low + " high: " + high);
        for(int i=low;i<=high;i++)sum += arr[i];
    }

    public int getSum(){
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6};
        int n = arr.length;

        ArraySum leftSum = new ArraySum(arr,0,n/2 - 1);
        ArraySum rightSum = new ArraySum(arr,n/2,n - 1);
        // step3: define threads
        // how to create thread? create runnable instance and pass it to the thread constructor
        Thread t1 = new Thread(leftSum);
        Thread t2 = new Thread(rightSum);

        // step4: start the threads
        // JVM will internally call run()
        t1.start();
        t2.start();
//        t1.start();

        // step5: wait for both thread to complete their execution of run() method
        t1.join();t2.join();

        // step6: sum the partial results of thread to get the final sum

        int totalSum = leftSum.getSum() + rightSum.getSum();
        System.out.println("Sum of arr: " + Arrays.toString(arr) +" is: " + totalSum);

    }
}
