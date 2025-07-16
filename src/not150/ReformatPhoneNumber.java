package src.not150;

public class ReformatPhoneNumber {

    private String cleanNumber(String number){
        StringBuffer result = new StringBuffer();
        for(char ch : number.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String helper(String str){
        if(str.length() <= 3){
            return str;
        }
        else if(str.length() == 4){
            return str.substring(0,2) + '-' + str.substring(2);
        }
        return str.substring(0,3) + '-' + helper(str.substring(3));
    }

    public String reformatNumber(String number) {
        number = cleanNumber(number);
        return helper(number);
    }

}
