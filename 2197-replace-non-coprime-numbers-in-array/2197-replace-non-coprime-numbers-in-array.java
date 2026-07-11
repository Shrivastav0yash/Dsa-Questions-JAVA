import java.math.BigInteger;
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            long curr = num;

            while (!ans.isEmpty()) {
                int top = ans.get(ans.size() - 1);
                long g = BigInteger.valueOf(top)
                                     .gcd(BigInteger.valueOf(curr))
                                     .longValue(); //GCD

                if (g == 1)
                    break;

                ans.remove(ans.size() - 1);
                curr = (top / g) * curr; //LCM
            }

            ans.add((int) curr);
        }

        return ans;
    }
}