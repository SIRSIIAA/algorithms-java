package search.test;

import org.junit.jupiter.api.Test;
import search.BinarySearch;

public class BinarySearchTest {
    @Test
    public void binarySearchTest() {
        var arr = new int[]{
                0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9
        };
        System.out.println(BinarySearch.binarySearch(arr, 1));
    }

    @Test
    public void binarySearchLeftBoundTest() {
        var arr = new int[]{
                0, 0, 0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9
        };
        var target = 0;
        var sb = new StringBuilder(30);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(BinarySearch.binarySearchFindTheLeftBound(arr, target));
        System.out.println(sb.indexOf(target + ""));
        assert BinarySearch.binarySearchFindTheLeftBound(arr, target)
                == sb.indexOf(target + "");
    }
}
