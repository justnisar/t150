package src;

public class AddBinary {

    private String recFun(String a, String b, int carry){
        // base case
        if(a.equals("") && b.equals("")){
            return carry == 1 ? String.valueOf((char)(carry + '0')) : "";
        }
        int sum = a.equals("") ? 0 : (a.charAt(a.length() - 1) - '0');
        sum += b.equals("") ? 0 : (b.charAt(b.length() - 1) - '0');
        sum += carry;

        int digit = sum % 2;
        carry = sum / 2;
        String aNext = a.equals("") ? "" : a.substring(0, a.length() - 1);
        String bNext = b.equals("") ? "" : b.substring(0, b.length() - 1);
        return recFun(aNext, bNext, carry) + (char)(digit + '0');
    }

    public String addBinary(String a, String b) {
        return recFun(a, b , 0);
    }

    public static void main(String[] args) {
        new AddBinary().addBinary("0", "0");
    }

}
