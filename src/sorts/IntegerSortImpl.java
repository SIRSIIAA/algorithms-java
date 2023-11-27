package sorts;

import utils.IntegerUtils;
import utils.RandomGenerator;

import java.util.*;

/**
 * implements int sort
 */
public class IntegerSortImpl {
    /*
     * sort based algorithms
     */
    public static void bubbleSort(int[] arr) {
        /*
         * i --> how many elements to be sorted
         * j --> bubble the current element,
         * arr.length - 1 --> the top limitation of j, then j+1 can reach index arr.length-1
         * arr.length - 1 - i --> i stands for how many elements have already been sorted,
         * there is no need for visiting them again in a bubbleSort
         *
         * stable
         *
         * time complexity N^2
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
         *
         * unstable
         *
         * time complexity N^2
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
         *
         * stable
         *
         * time complexity N^2
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] < arr[j - 1]; j--) {
                IntegerUtils.swap(arr, j - 1, j);
            }
        }
    }

    public static void mergeSort(int[] arr) {
        processMergeSort(arr, 0, arr.length - 1);
    }

    private static void processMergeSort(int[] arr, int l, int r) {
        /*
         * stable
         *
         * time complexity NLOGN
         * space complexity N
         *
         * CAUTIONS!
         * 1. we can turn the space complexity of a mergeSort to O1 by using inner cache
         * however we will lose the stability
         * 2. someone acclaims that they can turn the space complexity of a mergeSort an in-place sort
         * however the time complexity will be ON2
         * wft are you doing?
         */
        if (l == r) {
            return;
        }
        var mid = ((r - l) >> 1) + l;
        processMergeSort(arr, l, mid);
        processMergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        var lStart = l;
        var rStart = mid + 1;
        var tmpArr = new int[r - l + 1];
        var pointer = 0;
        while (lStart <= mid && rStart <= r) {
            tmpArr[pointer++] = arr[lStart] < arr[rStart] ? arr[lStart++] : arr[rStart++];
        }
        while (lStart <= mid) {
            tmpArr[pointer++] = arr[lStart++];
        }
        while (rStart <= r) {
            tmpArr[pointer++] = arr[rStart++];
        }
        System.arraycopy(tmpArr, 0, arr, l, tmpArr.length);
    }

    public static void quickSort(int[] arr) {
        processQuickSort(arr, 0, arr.length - 1);
    }

    private static void processQuickSort(int[] arr, int l, int r) {
        /*
         * unstable, because partition is unstable
         * [6,7,6,6,3],while the partition value is 5
         * while swapping the first 6 with the last 3, it is unstable
         *
         * time complexity NLOGN
         * space complexity NLOGN
         *
         * CAUTIONS!
         * 1. we can turn a quickSort stable by using 01 stable sort
         */
        if (l >= r) {
            return;
        }
        IntegerUtils.swap(arr, r, RandomGenerator.generateNumber(l, r));
        var initialBounds = partition(arr, l, r);
        processQuickSort(arr, l, initialBounds[0]);
        processQuickSort(arr, initialBounds[1], r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        /*
         * another traditional question is:
         * 1. put all given odd number on the left of the given array
         * 2. likely, put all given even number on the right of the given array
         * 3. the relative sort can not be changed!
         * 4. implements an algorithms with N time complexity and 1 space complexity
         *
         * the answer is impossible
         */
        var leftBound = l - 1;
        var rightBound = r + 1;
        var randomIdx = RandomGenerator.generateNumber(l, r);
        IntegerUtils.swap(arr, randomIdx, r);
        var model = arr[r];
        var i = l;
        while (i < rightBound) {
            var cur = arr[i];
            if (cur > model) {
                IntegerUtils.swap(arr, i, --rightBound);
            } else if (cur < model) {
                IntegerUtils.swap(arr, i++, ++leftBound);
            } else {
                i++;
            }
        }
        /*
         * the right bound must be a legal index
         */
        if (rightBound != r + 1) {
            IntegerUtils.swap(arr, r, rightBound);
        }
        return new int[]{leftBound, rightBound};
    }

    /*
     * FIXME
     */
    public static void heapSort(int[] arr) {
        processHeapSort(arr, 0, arr.length - 1);
    }

    private static void processHeapSort(int[] arr, int l, int r) {
        /*
         * unstable
         * [5,4,4,6],while heapify the last 6, it is unstable
         *
         * time complexity NLOGN
         */

    }

    private static void heapInsert(int[] arr, int idx) {
        while (idx > 0 && arr[idx] > arr[(idx - 1) >> 1]) {
            IntegerUtils.swap(arr, idx, (idx - 1) >> 1);
            idx = (idx - 1) >> 1;
        }
    }

    private static void heapify(int[] arr, int idx, int heapSize) {

    }

    /*
     * un sort based algorithms
     */

    public static void radixSort(int[] arr) {
        processRadixSort(arr);
    }

    private static void processRadixSort(int[] arr) {
        /*
         * stable
         *
         * time complexity NLOGN
         */
        var buckets = new int[10];
        var tmp = new int[arr.length];
        var cnt = findMaxLength(arr);
        for (int i = 0; i < cnt; i++) {
            fillBuckets(arr, buckets, i + 1);
            applyBuckets(arr, tmp, buckets, i + 1);
        }
    }

    private static int findMaxLength(int[] arr) {
        var max = arr[0];
        for (int j : arr) {
            max = Math.max(j, max);
        }
        var cnt = 0;
        while (max != 0) {
            cnt++;
            max /= 10;
        }
        return cnt;
    }

    private static int getBit(int num, int bit) {
        return ((int) (num / Math.pow(10, bit - 1))) % 10;
    }

    private static void fillBuckets(int[] arr, int[] buckets, int bit) {
        for (int j : arr) {
            var code = getBit(j, bit);
            buckets[code]++;
        }
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }
    }

    private static void applyBuckets(int[] arr, int[] tmp, int[] buckets, int bit) {
        for (int i = arr.length - 1; i > -1; i--) {
            var cur = getBit(arr[i], bit);
            tmp[buckets[cur] - 1] = arr[i];
            buckets[cur]--;
        }
        System.arraycopy(tmp, 0, arr, 0, tmp.length);
        /*
         * clear the buckets after use
         */
        Arrays.fill(buckets, 0);
    }
}
