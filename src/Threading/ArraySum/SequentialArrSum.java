package Threading.ArraySum;

public class SequentialArrSum {
    int [] arr;
    int low, high;
    int sum;
    public SequentialArrSum(int [] arr, int l, int r) {
        this.arr = arr;
        low = l;
        high = r;
        sum =  0;

    }
    public void calculate(){
        for(int i=low;i<=high;i++)sum += arr[i];
    }
    public int getSum(){
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        SequentialArrSum sequentialArrSum = new SequentialArrSum(arr,0,arr.length-1);
        sequentialArrSum.calculate();
        System.out.println(sequentialArrSum.getSum());
    }
}
