class Solution {
    public int smallestNumber(int n) {
        int x = n;
        boolean b = true;
        while (b) {
            String s = Integer.toBinaryString(x);
            b = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') { 
                    b = true;
                    break;
                }
            }
            x++;
        }
        return x - 1; 
    }
}
