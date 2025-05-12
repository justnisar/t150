package src;

public class LongestCommonPrefix {

    private int getMinimumStrLength(String[] strs){
        int result = Integer.MAX_VALUE;
        for(String str : strs){
            if(str.length() < result){
                result = str.length();
            }
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int length = getMinimumStrLength(strs);
        for(int i = 0 ; i < length ; i++){
            char prefixForNow = strs[0].charAt(i);
            for(int j = 1 ; j < strs.length ; j++){
                if(strs[j].charAt(i) != prefixForNow){
                    return prefix;
                }
            }
            prefix += prefixForNow;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] array = {"cir","car"};
        new LongestCommonPrefix().longestCommonPrefix(array);
    }

}
