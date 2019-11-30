import java.util.Arrays;

public class MergeSort {

    public void Sort(int[] arr){
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    private int[] sort(int[] arr) {

        if (arr.length<2){
            return arr;
        }
        int middle=arr.length/2;
        int[] arrleft=Arrays.copyOfRange(arr,0,middle);
        int[] arrright=Arrays.copyOfRange(arr,middle,arr.length);
        return merge(sort(arrleft),sort(arrright));
    }

    private static int[] merge(int[] left,int[] right){
        //先声明一个空间，空间长度为两个序列的长度之和    int[] array={12,34,23,56,67,45};
        int[] resoultarray=new int[left.length+right.length];
        //循环遍历数组  拿出最小的值copy到新数组中
        int resoultindex=0,leftindex=0,rightindex=0;
        while (true){
            if (left[leftindex]<=right[rightindex]){
                resoultarray[resoultindex++]=left[leftindex++];
                if (leftindex==left.length) break;
            }else{
                resoultarray[resoultindex++]=right[rightindex++];
                if (rightindex==right.length) break;
            }
        }


        //左边的数组没有完成  把左边剩余元素赋值给结果数组
        while (leftindex<left.length){
            resoultarray[resoultindex++]=left[leftindex++];
        }

        ////右边的数组没有完成 把右边剩余元素赋值给结果数组
        while (rightindex<right.length){
            resoultarray[resoultindex++]=right[rightindex++];
        }

        return resoultarray;
    }
}
