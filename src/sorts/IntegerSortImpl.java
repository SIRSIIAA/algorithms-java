package sorts;

import utils.IntegerUtils;

/**
 * implements int sort
 */
public class IntegerSortImpl {
    public static void bubbleSort(int[] arr) {
        /*
         * i --> how many elements to be sorted
         * j --> bubble the current element,
         * arr.length - 1 --> the top limitation of j, then j+1 can reach index arr.length-1
         * arr.length - 1 - i --> i stands for how many elements have already been sorted,
         * there is no need for visiting them again in a bubbleSort
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    IntegerUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        /*
         * the array may like this:
         * sorted -- i -- chaos
         * [--sorted--][i--chaos]
         * the i is the first chaos element
         */
        for (int i = 0; i < arr.length - 1; i++) {
            var minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            IntegerUtils.swap(arr, minIdx, i);
        }
    }

    public static void insertSort(int[] arr) {
        /*
         * the array may like this:
         * sorted -- i -- chaos
         * [--sorted---i][chaos]
         * the i is the last sorted element
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] < arr[j - 1]; j--) {
                IntegerUtils.swap(arr, j - 1, j);
            }
        }
    }
}
