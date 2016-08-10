import java.util.HashSet;
import java.util.Set;

public class DeDup {

    public static int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
            19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
            3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};

    public static void main(String[] args) {
        int newSize = removeDupInOrignalOrder(randomIntegers, randomIntegers.length);
        System.out.println("Non Duplicate Valuse in same order :- ");
        for (int i = 0; i < newSize; i++) {
            System.out.println(randomIntegers[i] + "");
        }
        removeDup();

        removeDuplicates(randomIntegers);
    }

    public static int removeDupInOrignalOrder(int[] a, int currentSize) {
        int start = 0;
        while (start < currentSize) {
            int removed = removeFromTail(a, currentSize, start + 1, a[start]);
            currentSize = currentSize - removed;
            start++;
        }
        return currentSize;
    }

    private static int removeFromTail(int[] a, int currentSize, int start, int toBeRemoved) {
        // TODO Auto-generated method stub
        int source = start;
        int target = start;
        int removed = 0;
        while (source < currentSize) {
            if (a[source] == (toBeRemoved)) {
                removed++;
            } else {
                a[target] = a[source];
                target++;
            }
            source++;
        }
        return removed;
    }

    public static void removeDup() {
        Set<Integer> values = new HashSet<Integer>();
        for (int i = 0; i < randomIntegers.length; i++) {
            values.add(randomIntegers[i]);
        }
        System.out.println("Non Duplicate Values Using Set     : -" + values);
    }

    public static int[] removeDuplicates(int[] arr) {

        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];
        System.out.println("\n*******Returning Non Duplicate List***********");
        for (int i = 0; i < end; i++) {
            whitelist[i] = arr[i];
            System.out.println(whitelist[i]);
        }
        return whitelist;
    }
}