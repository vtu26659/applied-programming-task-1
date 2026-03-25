import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0) return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        // start with first column
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            
            int u = curr[0];
            int v = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(u, v));

            // move in nums2
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{u, nums2[j + 1], j + 1});
            }
        }

        return result;
    }
}