public class RansomNote {

    private int[] getLetterCount(String str){
        int[] result = new int[26];
        for(char ch : str.toCharArray()){
            result[ch - 'a']++;
        }
        return result;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineLetterCount = getLetterCount(magazine);
        for(char ch : ransomNote.toCharArray()){
            if(magazineLetterCount[ch - 'a'] == 0){
                return false;
            }
            magazineLetterCount[ch - 'a']--;
        }
        return true;
    }
}
