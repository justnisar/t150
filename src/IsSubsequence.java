package src;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for(char ch : t.toCharArray()) {

            if(start < s.length() && ch == s.charAt(start)){
                start++;
            }

        }

        return start == s.length();
    }
}
