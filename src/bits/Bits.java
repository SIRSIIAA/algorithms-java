package bits;

public class Bits {
    public static int findTheRightOne(int target) {
        return target & (~target + 1);
    }

    /*
     * question: there are only two different numbers which appear odd times among the given array,
     * while others appear even times
     * you must find them in O(N) time complexity and O(1) space complexity
     */
    public static int[] findTwoNumbersFromArray(int[] arr) {
        var summary = 0;
        for (int i = 0; i < arr.length; i++) {
            summary ^= arr[i];
        }
        /*
         * one number stands for the decimal representation of the summary
         */
        var theRightOneOfSummary = findTheRightOne(summary);
        var first = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((theRightOneOfSummary & arr[i]) == 1) {
                first ^= arr[i];
            }
        }
        return new int[]{
                first,
                summary ^ first
        };
    }
}
