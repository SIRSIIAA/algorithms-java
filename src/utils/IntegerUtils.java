package utils;

public class IntegerUtils {
    /*
     * we can understand the exclusive OR an addition without carry
     */
    public static void swap(int[] arr, int i, int j) {
        if (arr.length > 1 && i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }
}
