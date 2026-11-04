import java.util.Arrays;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Coordinate compression.
        int[] vals = nums.clone();
        Arrays.sort(vals);

        int m = 0;
        for (int v : vals) {
            if (m == 0 || vals[m - 1] != v) {
                vals[m++] = v;
            }
        }

        // Convert each number to its compressed rank.
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;
        }

        // Fenwick trees for frequencies and value sums.
        int[] count = new int[m + 1];
        long[] sum = new long[m + 1];

        int highest = Integer.highestOneBit(m);
        int need = (x + 1) / 2;
        int windows = n - x + 1;

        long[] cost = new long[windows];
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
            update(rank[i], 1, nums[i], count, sum, m);

            // Remove the element leaving the window.
            if (i >= x) {
                total -= nums[i - x];
                update(rank[i - x], -1, -nums[i - x], count, sum, m);
            }

            if (i >= x - 1) {
                int pos = 0;
                int remaining = need;
                long lowerSum = 0;

                // Find the coordinate containing the need-th smallest value.
                for (int bit = highest; bit != 0; bit >>= 1) {
                    int next = pos + bit;
                    if (next <= m && count[next] < remaining) {
                        pos = next;
                        remaining -= count[next];
                        lowerSum += sum[next];
                    }
                }

                long median = vals[pos];
                long lowerCount = need - remaining;

                // Sum of absolute differences from the median.
                cost[i - x + 1] =
                        median * lowerCount - lowerSum
                        + (total - lowerSum) - median * (x - lowerCount);
            }
        }

        // Rolling DP: minimum cost to place j non-overlapping windows.
        final long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] cur = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(cur, INF);

            for (int i = x; i <= n; i++) {
                long skip = cur[i - 1];
                long take = prev[i - x] + cost[i - x];
                cur[i] = Math.min(skip, take);
            }

            long[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[n];
    }

    private void update(int index, int delta, int value,
                        int[] count, long[] sum, int m) {
        for (int i = index; i <= m; i += i & -i) {
            count[i] += delta;
            sum[i] += value;
        }
    }
}