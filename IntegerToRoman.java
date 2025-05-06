public class IntegerToRoman {

    private String getName(String ch, int n){
        StringBuilder result = new StringBuilder();
        while(n != 0){
            result.append(ch);
            n--;
        }
        return result.toString();
    }

    public String intToRoman(int num) {

        int[] denominaions = {1000, 900,   500,  400,  100,  90,  50,    40,  10,   9,    5,   4,  1};
        String[] symbols = {   "M", "CM" , "D",  "CD", "C",  "XC", "L", "XL", "X", "IX", "V",  "IV", "I"}  ;

        String result = "";
        int i = 0;
        while(num != 0){
            int quotient = num / denominaions[i];
            if(quotient == 0){
                i++;
                continue;
            }
            result += getName(symbols[i], quotient);
            num = num - denominaions[i] * quotient;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        new IntegerToRoman().intToRoman(3749);
    }
}
