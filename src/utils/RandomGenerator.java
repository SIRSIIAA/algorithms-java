package utils;


public class RandomGenerator {
    public static int generateNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int[] generate1DIntegerArray(int size, int min, int max) {
        var res = size < 1 ? new int[]{} : new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = generateNumber(min, max);
        }
        return res;
    }
}
