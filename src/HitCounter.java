package src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    private int[] timestamps;
    private int[] hits;
    public HitCounter() {
        timestamps = new int[300];
        hits = new int[300];
    }

    public void hit(int timestamp) {
        // check existing time stamp is stale
        int bucket = timestamp % 300;
        if(timestamps[bucket] == timestamp){
            hits[bucket]++;
        }
        else{
            timestamps[bucket] = timestamp;
            hits[bucket] = 1;
        }
    }

    public int getHits(int timestamp) {
        int totalHits = 0;
        for(int i = 0 ; i < 300 ; i++){
            if(timestamp - timestamps[i] < 300){
                totalHits += hits[i];
            }
        }
        return totalHits;
    }
}
