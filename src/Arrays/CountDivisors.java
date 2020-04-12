package Arrays;

import Util.ScalerUtils;

import java.util.HashMap;
import java.util.Map;

public class CountDivisors {
    public static int[] countDivisors(int[] arr) {
        int count = 0;
        int[] res = new int[arr.length];
        Map<Integer, Integer> factorMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (factorMap.containsKey(arr[i])) {
                count = factorMap.get(arr[i]);
                res[i] = count;
                count = 0;
                continue;
            }
            for (int j = 1; j <= arr[i]; j++) {
                if (arr[i] % j == 0)
                    count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5 };
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(countDivisors(arr));
    }
}
