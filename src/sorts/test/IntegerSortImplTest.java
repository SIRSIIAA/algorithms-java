package sorts.test;

import org.junit.jupiter.api.Test;
import sorts.IntegerSortImpl;
import utils.RandomGenerator;

import java.util.Arrays;

public class IntegerSortImplTest {
    @Test
    public void testBubbleSort() {
        var size = 2000;
        var min = 1;
        var max = 1000;
        var res = RandomGenerator.generate1DIntegerArray(size, min, max);
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.bubbleSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

    @Test
    public void testSelectionSort() {
        var size = 2000;
        var min = 1;
        var max = 1000;
        var res = RandomGenerator.generate1DIntegerArray(size, min, max);
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.selectionSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

    @Test
    public void testInsertSort() {
        var size = 20000;
        var min = 1;
        var max = 1000;
        var res = RandomGenerator.generate1DIntegerArray(size, min, max);
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.insertSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

    @Test
    public void testMergeSort() {
        var size = 20000;
        var min = 1;
        var max = 1000;
        var res = RandomGenerator.generate1DIntegerArray(size, min, max);
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.mergeSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

    @Test
    public void testQuickSort() {
        var size = 20000;
        var min = 1;
        var max = 1000;
        var res = RandomGenerator.generate1DIntegerArray(size, min, max);
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.quickSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

    @Test
    public void testHeapSort() {
        var size = 6;
        var res = new int[]{
                3, 7, 6, 8, 5, 12
        };
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.heapSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

    @Test
    public void testRadixSort() {
        var size = 20000;
        var min = 1;
        var max = 1000;
        var res = RandomGenerator.generate1DIntegerArray(size, min, max);
        var targetRes = Arrays.copyOf(res, size);
        Arrays.sort(targetRes);
        IntegerSortImpl.radixSort(res);
        for (int i = 0; i < size; i++) {
            assert res[i] == targetRes[i];
        }
    }

}
