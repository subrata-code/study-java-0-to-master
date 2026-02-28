import java.util.*;

class Closest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of first array
        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input size of second array
        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        // Target value
        System.out.print("Enter target value: ");
        int x = sc.nextInt();

        findClosestPair(arr1, arr2, x);
    }

    public static void findClosestPair(int[] arr1, int[] arr2, int x) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = arr2.length - 1;

        int minDiff = Integer.MAX_VALUE;
        int res1 = 0, res2 = 0;

        while (i < arr1.length && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);

            if (diff < minDiff) {
                minDiff = diff;
                res1 = arr1[i];
                res2 = arr2[j];
            }

            if (sum > x) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Closest pair: (" + res1 + ", " + res2 + ")");
    }
}