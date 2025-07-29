package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ipo {

    /**
     * Finds the maximized capital after finishing at most k distinct projects using a greedy, two-heap approach.
     * <p>
     * The core idea is to always pick the most profitable project from the pool of projects that are currently affordable.
     *
     * <p><b>Strategy:</b></p>
     * <ol>
     *   <li>A <b>Min-Heap (`capitalMinHeap`)</b> acts as a "waiting room" for all projects, sorted by their required capital.
     *       This allows us to efficiently find projects that become affordable as our capital `w` increases.</li>
     *
     *   <li>A <b>Max-Heap (`profitMaxHeap`)</b> acts as a "ready pool" to hold the profits of all projects that we can
     *       currently afford. This allows us to instantly select the most profitable option.</li>
     * </ol>
     *
     * The algorithm iterates up to `k` times. In each iteration, it:
     * <br>a) Moves all newly affordable projects from the `capitalMinHeap` to the `profitMaxHeap`.
     * <br>b) Selects the project with the highest profit from the `profitMaxHeap` to undertake.
     *
     * @param k       The maximum number of projects to complete.
     * @param w       The initial capital.
     * @param profits An array of profits for each project.
     * @param capital An array of capital required for each project.
     * @return The final maximized capital.
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Min heap of capital-profit pairs sorted by capital
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0])
        );

        // Add all capital-profit pairs to min heap
        for(int i = 0 ; i < capital.length; i++){
            capitalMinHeap.add(new int[]{capital[i], profits[i]});
        }

        // Max heap of profits
        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        for(int i = 0; i < k; i++){

            // Maintain a max heap of profits
            while(!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= w){
                int[] capitalProfitPair = capitalMinHeap.poll();
                profitMaxHeap.add(capitalProfitPair[1]);
            }

            // We can stop if there are no jobs left
            if(profitMaxHeap.isEmpty()){
                break;
            }

            int profit = profitMaxHeap.poll();
            w += profit;
        }

        return w;
    }

}
