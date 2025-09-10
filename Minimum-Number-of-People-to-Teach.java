class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> langList = new ArrayList<>();
        for (int[] lang : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : lang) set.add(l);
            langList.add(set);
        }

        Set<Integer> need = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            boolean can = false;
            for (int l : langList.get(u)) {
                if (langList.get(v).contains(l)) {
                    can = true;
                    break;
                }
            }
            if (!can) {
                need.add(u);
                need.add(v);
            }
        }

        if (need.isEmpty()) return 0;

        int res = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;
            for (int user : need) {
                if (!langList.get(user).contains(lang)) cnt++;
            }
            res = Math.min(res, cnt);
        }

        return res;
    }
}