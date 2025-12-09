1class Solution {
2    public int specialTriplets(int[] nums) {
3        int n = nums.length;
4        final int MOD = 1_000_000_007;
5        Map<Integer, Integer> lFreq = new HashMap<>();
6        Map<Integer, Integer> rFreq = new HashMap<>();
7        for (int num : nums) {
8            rFreq.put(num,rFreq.getOrDefault(num, 0) + 1);
9        }
10        long result = 0;
11
12        for (int j = 0; j < n; j++) {
13            rFreq.put(nums[j], rFreq.get(nums[j]) - 1);
14            int c_l = lFreq.getOrDefault(nums[j] * 2, 0);
15            int c_r = rFreq.getOrDefault(nums[j] * 2, 0);
16            result = (result + (long)c_l * c_r) % MOD;
17            lFreq.put(nums[j], lFreq.getOrDefault(nums[j], 0) + 1);
18        }
19
20        return (int) result;
21    }
22}