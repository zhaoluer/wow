import java.util.Arrays;

public class InsertSort implements SortArray {
    @Override
    public void Sort(int[] arr) {
        //从下标为1的的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认有序
        for (int i = 1; i <arr.length ; i++) {
            int tmp=arr[i];
            //从有序序列的最右边开始比较，找到合适的位置(第一个比tmp小的数)
            int j;
            for (j = i-1; j >=0 && arr[j]>tmp ; j--) {
                arr[j+1]=arr[j];
            }
            arr[j+1]=tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
