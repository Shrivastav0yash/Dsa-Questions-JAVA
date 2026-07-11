class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            long curr = num;

            while (!ans.isEmpty()) {
                int top = ans.get(ans.size() - 1);
                long g = gcd(top, curr);

                if (g == 1)
                    break;

                ans.remove(ans.size() - 1);
                curr = (top / g) * curr;
            }

            ans.add((int) curr);
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}