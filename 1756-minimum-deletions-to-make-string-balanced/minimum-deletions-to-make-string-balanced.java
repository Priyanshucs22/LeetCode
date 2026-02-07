class Solution {
    public int minimumDeletions(String s) {
        int l = s.length();
        int prefix = 0;
        int total = 0;
        for (int i = 0; i < l; i++) 
        {
            if (s.charAt(i) == 'b') 
                prefix++;
            else if(s.charAt(i) == 'a' && prefix > 0)
            {
                prefix--;
                total++;
            }
        }
        return total;
    }
}                                                                        