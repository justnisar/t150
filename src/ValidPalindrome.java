package src;

public class ValidPalindrome {

    private boolean isAlphanumeric(char ch){
        return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9';
    }

    public boolean isPalindrome(String s) {
       int i = 0;
       int j = s.length() - 1;
       while(i < j){

           while(i < s.length() && !isAlphanumeric(s.charAt(i))){
               i++;
           }
           while(j >= 0 && !isAlphanumeric(s.charAt(j))){
               j--;
           }
           if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
               return false;
           }
           i++;
           j--;
       }

       return true;
    }

    public static void main(String[] args) {
        System.out.println(Character.toLowerCase(','));
    }
}
