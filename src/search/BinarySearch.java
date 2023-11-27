package search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        var left = 0;
        var right = arr.length - 1;
        while (left <= right) {
            var mid = ((right - left) >> 1) + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
     * FIXME
     */
    public static int binarySearchFindTheLeftBound(int[] arr, int target) {
        var left = 0;
        var right = arr.length - 1;
        var mid = 0;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
