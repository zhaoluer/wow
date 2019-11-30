import java.util.Arrays;

public class BubbleSort implements SortArray{

    @Override
    public void Sort(int[] arr) {
        //对Array进行拷贝
        int[] array = Arrays.copyOf(arr, arr.length);
        for (int i=1;i<array.length;i++){
            //设置一个标记，假如标记为true则此次循环没有进行位置交换，证明已经有序，排序已经完成
            boolean flag=true;
            for (int j = 0; j <array.length-i ; j++) {
                if (array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag=false;
                }
            }
            if (flag) break;
        }
        System.out.println(Arrays.toString(array));
    }
}
