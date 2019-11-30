import java.util.Random;

/**
 * Create by zhaolulu on 2019/12/1 0:27
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr=new int[100];
        for (int i = 0; i < 100 ; i++) {
            int num = random.nextInt(1000);
            arr[i]=num;
        }


        BubbleSort sort=new BubbleSort();
        sort.Sort(arr);
        InsertSort insertSort = new InsertSort();
        insertSort.Sort(arr);
        MergeSort mergeSort = new MergeSort();
        mergeSort.Sort(arr);
    }
}
