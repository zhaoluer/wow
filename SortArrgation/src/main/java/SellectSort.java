import java.util.Arrays;

public class SellectSort implements SortArray {
    @Override
    public void Sort(int[] arr) {
        //总共经过arr.length-1轮比较，每轮将一个最小的放到前面
        for(int i=0;i<arr.length;i++){
            int min=i;
            //每轮需要比较的次数 arr.length-1 找到最小的数的索引
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j]<arr[min]){
                    min=j;
                }
            }

            //将找到的最小值和i所在的位置交换
            if (i !=min){
                int tmp=arr[i];
                arr[i]=arr[min];
                arr[min]=tmp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
