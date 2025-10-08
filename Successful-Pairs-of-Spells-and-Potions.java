class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) { 
            int e = spells[i]; 
            int x = 0; 
            int y = potions.length - 1; 
            int idx = potions.length; 
            while (x <= y) { 
                int mid = (x + y) / 2; 
                if ((long) e * potions[mid] >= success) { 
                    idx = mid; 
                    y = mid - 1; 
                } 
                else { 
                    x = mid + 1; 
                } 
            } 
            ans[i] = potions.length - idx; 
        } 
        return ans;
    }
}