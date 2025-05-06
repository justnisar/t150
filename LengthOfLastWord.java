public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] sArr = s.strip().split(" ");
        return sArr[sArr.length - 1].length();
    }
}
