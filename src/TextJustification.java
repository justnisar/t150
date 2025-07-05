package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {

    private List<List<String>> getLines(String[] words, int maxWidth){

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int charCount = 0;
        for(String word : words){
            charCount += word.length();
            if(charCount + temp.size() > maxWidth){
                result.add(temp);
                temp = new ArrayList<>();
                charCount = word.length();
            }
            temp.add(word);
        }

        if(temp.size() != 0){
            result.add(temp);
        }

        return result;
    }

    private String makeNonLastLine(List<String> line, int maxWidth){
        char[] resultArray = new char[maxWidth];
        Arrays.fill(resultArray, ' ');

        int filledCells = line.stream().mapToInt(String::length).sum();
        int spaceCount = maxWidth - filledCells;
        int gapCount = line.size() - 1;
        int evenSpace = gapCount == 0 ? 0 : spaceCount / gapCount;
        int extraSpaces = gapCount == 0 ? 0 : spaceCount % gapCount;
        int index = 0;
        for(String word : line){
            for(char ch : word.toCharArray()){
                resultArray[index] = ch;
                index++;
            }
            int movesToRight = evenSpace;
            if(extraSpaces > 0){
                movesToRight++;
                extraSpaces--;
            }
            index += movesToRight;
        }


        return new String(resultArray);
    }

    private String makeLastLine(List<String> line, int maxWidth){
        char[] resultArr = new char[maxWidth];
        Arrays.fill(resultArr, ' ');
        int index = 0;
        for(String word : line){
            for(char ch : word.toCharArray()){
                resultArr[index] = ch;
                index++;
            }
            index++;
        }
        return new String(resultArr);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<List<String>> lines = getLines(words, maxWidth);
        List<String> result = new ArrayList<>();

        for(int i = 0 ; i < lines.size() - 1 ; i++){
            result.add(makeNonLastLine(lines.get(i), maxWidth));
        }
        result.add(makeLastLine(lines.getLast(), maxWidth));
        return result;

    }

    public static void main(String[] args) {

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;



        /*
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        */

        new TextJustification().fullJustify(words, maxWidth);
    }
}
