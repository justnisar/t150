package src.not150;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class UnionIterator<T extends Comparable<T>> {

    /*
    private PriorityQueue<Pair<T>> heap;
    private Iterator<T> it1;
    private Iterator<T> it2;

    public UnionIterator(Iterator<T> it1, Iterator<T> it2) {
        this.it1 = it1;
        this.it2 = it2;
        heap = new PriorityQueue<>((Pair<T> p1, Pair<T> p2) -> p1.element.compareTo(p2.element));
        if(it1 != null){
            heap.add(new Pair<>(it1));
        }
        if(it2 != null){
            heap.add(new Pair<>(it2));
        }
    }

    public T next(){
        Pair pair = heap.poll();
        T result = (T) pair.element;
        if(pair.iterator.hasNext()){
            pair.element = pair.iterator.next();
            heap.add(pair);
        }
        return result;
    }

    public boolean hasNext(){
        return !heap.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3,5);
        List<Integer> list2 = Arrays.asList(2,3,4);
        UnionIterator<Integer> iterator = new UnionIterator<>(list1.iterator(), list2.iterator());
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Pair<T>{

    public Iterator<T> iterator;
    public T element;

    public Pair(Iterator<T> iterator) {
        this.iterator = iterator;
        this.element = iterator.next();
    }
     */

    private Iterator<T> it1;
    private Iterator<T> it2;
    private T current1;
    private T current2;

    public UnionIterator(Iterator<T> it1, Iterator<T> it2){
        this.it1 = it1;
        this.it2 = it2;
        current1 = it1.hasNext() ? it1.next() : null;
        current2 = it2.hasNext() ? it2.next() : null;
    }

    public T next(){
        if(!hasNext()){
            return null;
        }
        T result = null;
        if(current1 == null){
            result = current2;
            current2 = it2.hasNext() ? it2.next() : null;
        }
        else if(current2 == null){
            result = current1;
            current1 = it1.hasNext() ? it1.next() : null;
        }
        else{
            if(current1.compareTo(current2) <= 0){
                result = current1;
                current1 = it1.hasNext() ? it1.next() : null;
            }
            else{
                result = current2;
                current2 = it2.hasNext() ? it2.next() : null;
            }
        }
        return result;
    }

    public boolean hasNext(){
        return current1 != null || current2 != null ;
    }

    public static void main(String[] args) {
        Iterator it1 = Arrays.asList(1, 2, 3, 5, 8, 13).iterator();
        Iterator it2 = Arrays.asList(2, 4, 6, 8, 10).iterator();
        UnionIterator unionIterator = new UnionIterator(it1, it2);
        while(unionIterator.hasNext()){
            System.out.println(unionIterator.next());
        }
    }

}


