import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int p = num.length - 1;
        int carry = 0;

        while (p >= 0 || k > 0) {
            int numval = 0;

            if (p >= 0) {
                numval = num[p];
            }

            int d = k % 10;   // last digit of k
            int sum = numval + d + carry;

            int digit = sum % 10;
            carry = sum / 10;

            ans.add(digit);
            p--;
            k = k / 10;
        }

        if (carry > 0) {
            ans.add(carry);
        }

        Collections.reverse(ans);
        return ans;
    }
}

public class AddToArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of digits in array: ");
        int n = sc.nextInt();

        int[] num = new int[n];

        // Input array elements
        System.out.println("Enter digits of the number (space separated): ");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        // Input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        // Create object
        Solution sol = new Solution();

        // Call function
        List<Integer> result = sol.addToArrayForm(num, k);

        // Print result
        System.out.println("Result after addition:");
        for (int digit : result) {
            System.out.print(digit + " ");
        }

        sc.close();
    }
}