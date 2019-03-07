import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        minPQ.add(num);
        maxPQ.add(num);
        if(minPQ.size() < maxPQ.size()) {
            minPQ.add(maxPQ.remove());
        }
    }

    public double findMedian() {
        return minPQ.size() > maxPQ.size() ? (double)minPQ.peek() : (minPQ.peek() + maxPQ.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */