class Solution {
    public String sortVowels(String s) {
        String x = "";
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                x += a;
            }
        }
        char[] tempArray = x.toCharArray();
        Arrays.sort(tempArray);
        String o = new String(tempArray);
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                output += o.charAt(k);
                k++;
            } else {
                output += s.charAt(i);
            }
        }
        return output;
    }
}
