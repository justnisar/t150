package src;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if(minHeap.isEmpty() || num <= minHeap.peek()){
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }
        }
        else{
            minHeap.add(num);
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        return (double)(maxHeap.peek() + minHeap.peek())/2;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}