package src;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0, currentGain = 0;
        int startPoint = 0;
        for(int i = 0 ; i < gas.length ; i++){
            totalGain += gas[i] - cost[i];
            currentGain += gas[i] - cost[i];
            if(currentGain < 0){
                startPoint = i + 1;
                currentGain = 0;
            }
        }
        return totalGain < 0 ? - 1 : startPoint;
    }
}
