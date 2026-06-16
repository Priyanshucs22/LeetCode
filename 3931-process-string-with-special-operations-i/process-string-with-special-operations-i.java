class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') sb.append(sb.toString());
            else if (c == '%') sb.reverse();
            else if (c == '*') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            } else sb.append(c);
        }
        return sb.toString();
    }
}