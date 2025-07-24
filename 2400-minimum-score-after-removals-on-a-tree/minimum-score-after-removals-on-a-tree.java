import java.util.*;

public class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] xor;
    int[] in, out, parent;
    int time = 0;
    int totalXor = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        tree = new ArrayList[n];
        xor = new int[n];
        in = new int[n];
        out = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }

        // Step 1: DFS to compute subtree XORs and in/out times
        dfs(0, -1);
        totalXor = xor[0];
        int res = Integer.MAX_VALUE;

        // Step 2: Try every pair of removable edges (each edge represented by child node)
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (parent[u] == -1 || parent[v] == -1)
                    continue;

                int xor1, xor2, xor3;

                // Case 1: v is ancestor of u
                if (isAncestor(v, u)) {
                    xor1 = xor[u];
                    xor2 = xor[v] ^ xor[u];
                    xor3 = totalXor ^ xor[v];
                }
                // Case 2: u is ancestor of v
                else if (isAncestor(u, v)) {
                    xor1 = xor[v];
                    xor2 = xor[u] ^ xor[v];
                    xor3 = totalXor ^ xor[u];
                }
                // Case 3: u and v are in different subtrees
                else {
                    xor1 = xor[u];
                    xor2 = xor[v];
                    xor3 = totalXor ^ xor[u] ^ xor[v];
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                res = Math.min(res, max - min);
            }
        }

        return res;
    }

    // DFS to compute subtree XORs and timestamps
    private void dfs(int u, int p) {
        in[u] = ++time;
        xor[u] = nums[u];
        parent[u] = p;

        for (int v : tree[u]) {
            if (v == p) continue;
            dfs(v, u);
            xor[u] ^= xor[v];
        }

        out[u] = ++time;
    }

    // Check if u is ancestor of v using in/out times
    private boolean isAncestor(int u, int v) {
        return in[u] < in[v] && out[v] < out[u];
    }
}