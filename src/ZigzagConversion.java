package src;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows ; i++){
            stringBuilders[i] = new StringBuilder();
        }

        boolean topToBottom = false;
        int currentRow = 0;
        for(char ch : s.toCharArray()){
            stringBuilders[currentRow].append(ch);
            if(currentRow == 0 || currentRow == numRows - 1){
                topToBottom = !topToBottom;
            }
            currentRow += topToBottom ? 1 : -1;
        }

        String result = "";
        for(StringBuilder sb : stringBuilders){
            result += sb != null ? sb.toString() : "";
        }

        return result;
    }

    public static void main(String[] args) {
        new ZigzagConversion().convert("PAYPALISHIRING", 3);
    }

}
