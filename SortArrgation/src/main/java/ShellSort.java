import java.util.Arrays;

public class ShellSort implements SortArray {
    @Override
    public void Sort(int[] arr) {
        //初始化一个合理的步进 step  {12,34,23,56,67,45}
        int step;
        for (step=arr.length/2; step>0 ; step/=2) {//步进
            //对每一组使用插入排序,遍历每组
            for (int i = 0; i <step ; i++) {
                //对每一组使用插入排序
                for (int j = i+step; j <arr.length ; j+=step) {
                    int tmp=arr[j];
                    //遍历j前面的元素
                    int k;
                    for (k = j-step; k >=0 && arr[k]>tmp; k-=step) {
                        arr[k+step]=arr[k];
                    }
                    //j+step 即为找到的位置，将tmp赋值给它
                    arr[k+step]=tmp;
                }
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
