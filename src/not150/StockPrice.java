package src.not150;

import java.util.Map;
import java.util.TreeMap;

public class StockPrice {

    private Map<Integer,Integer> timeStampToPriceMap;
    private Map<Integer,Integer> priceToCountMap;

    public StockPrice() {
        timeStampToPriceMap = new TreeMap<>();
        priceToCountMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if(timeStampToPriceMap.containsKey(timestamp)){
            int oldPrice = timeStampToPriceMap.get(timestamp);
            if(priceToCountMap.get(oldPrice) == 1){
                priceToCountMap.remove(oldPrice);
            }
            else{
                priceToCountMap.put(oldPrice, priceToCountMap.get(oldPrice) - 1);
            }
        }
        timeStampToPriceMap.put(timestamp, price);
        priceToCountMap.put(price, 1 + priceToCountMap.getOrDefault(price, 0));
    }

    public int current() {
        Integer highestKey = ((TreeMap<Integer,Integer>)timeStampToPriceMap).lastKey();
        return timeStampToPriceMap.get(highestKey);
    }

    public int maximum() {
        return ((TreeMap<Integer,Integer>)priceToCountMap).lastKey();
    }

    public int minimum() {
        return ((TreeMap<Integer,Integer>)priceToCountMap).firstKey();
    }

    public static void main(String[] args) {
        // The code from your snippet, demonstrating how the StockPrice class is used.
        System.out.println("--- How the StockPrice object is used ---");

        StockPrice obj = new StockPrice();
        obj.update(1, 10);
        int param_2 = obj.current();
        int param_3 = obj.maximum();
        int param_4 = obj.minimum();

        System.out.println("\n--- Example execution finished ---");
        System.out.println("Value of param_2 (from current): " + param_2);
        System.out.println("Value of param_3 (from maximum): " + param_3);
        System.out.println("Value of param_4 (from minimum): " + param_4);
    }

}


