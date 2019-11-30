public class QuickSort {

    public int[] Sort(int[] array) {
        int[] arr = quickSort(array, 0, array.length - 1);
        return arr;

    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            System.out.println(partition);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
        return arr;

    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）{12,34,23,56,67,45};
        int pivot = left;
        //指针，index-1 为最后的分区编号
        int index = pivot + 1;
        /**
         * 从基准值后面遍历序列，如过这个值比基准值小，并且这个值得索引等于当前遍历的索引i
         * 则不做操作，index+1,如果index值小于遍历的索引值（说明遍历过比基准值大的值），则将i
         * 和index位置的值交换位置，如果遍历的值比基准值大不做操作  i+1
         *
         * index最终指向的是第一个大于基准值得位置
         */
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                if (i!=index) swap(arr, i, index);
                index++;
            }
        }
        //将基准值和比基准值大的前一个值交换位置  分区结束
        swap(arr, pivot, index - 1);
        return index - 1;

    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
