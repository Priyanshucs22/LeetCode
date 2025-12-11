1class Solution {
2    public int countCoveredBuildings(int n, int[][] buildings) {
3        Map<Integer, TreeSet<Integer>> rowToCol = new HashMap<>();
4        Map<Integer, TreeSet<Integer>> colToRow = new HashMap<>();
5        for (int building[] : buildings) {
6            int x = building[0], y = building[1];
7            rowToCol.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
8            colToRow.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
9        }
10        int cnt = 0;
11        for (int building[] : buildings) {
12            int x = building[0], y = building[1];
13            
14            TreeSet<Integer> cols = rowToCol.get(x);
15            TreeSet<Integer> rows = colToRow.get(y);
16            
17            Integer left = cols.lower(y);
18            Integer right = cols.higher(y);
19            Integer up = rows.lower(x);
20            Integer down = rows.higher(x);
21            
22            if ((left != null) && (right != null) && (up != null) && (down != null)) {
23                cnt++;
24            }
25        }
26        return cnt;
27    }
28}