class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;

        // Step 1: Get powers of 2 from set bits of n
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        // Step 2: Prefix product array for quick range multiplication
        long[] prefixProd = new long[powers.size() + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefixProd[i + 1] = (prefixProd[i] * powers.get(i)) % MOD;
        }

        // Step 3: Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = (int)((prefixProd[right + 1] * modInverse(prefixProd[left], MOD)) % MOD);
        }

        return ans;
    }

    // Modular inverse using Fermat's little theorem
    private long modInverse(long a, int MOD) {
        return pow(a, MOD - 2, MOD);
    }

    private long pow(long base, long exp, int MOD) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
