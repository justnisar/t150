package src.not150;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class UnionIterator<T> {

    private PriorityQueue<Iterator<T>> heap;
    private Iterator<T> it1;
    private Iterator<T> it2;

    public UnionIterator(Iterator<T> it1, Iterator<T> it2) {
        this.it1 = it1;
        this.it2 = it2;
        heap = new PriorityQueue<>();
    }

    public T next(){
        return null;
    }

    public boolean hasNext(){
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3,5);
        List<Integer> list2 = Arrays.asList(2,3,4);
        UnionIterator<Integer> iterator = new UnionIterator<>(list1.iterator(), list2.iterator());

    }
}

class Pair<T>{
    public Iterator<T> iterator;
    public T element;


    public Pair(Iterator<T> iterator) {
        this.iterator = iterator;
        this.element = iterator.next();
    }
}
