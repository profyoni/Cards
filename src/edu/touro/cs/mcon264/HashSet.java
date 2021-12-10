package edu.touro.cs.mcon264;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashSet<T> implements java.util.Set<T> {

    private java.util.List<T>[] backingStore;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    public HashSet()
    {
        backingStore = (List<T>[]) new List[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashSetIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (contains(t))
            return false;
        if (loadFactorExceeded())
        {
            resize();
        }
        int hc = t.hashCode();
        int index = Math.abs(hc % backingStore.length);
        if (index == Integer.MIN_VALUE)
            index = 613;

        if (backingStore[index] == null)
            backingStore[index] = new LinkedList<>();
        List<T> bucket = backingStore[index];
        bucket.add(t);
        size++;
        return true;
    }

    private void resize() {
        // double backing store
        // rehash into new backing store
    }
    private boolean loadFactorExceeded() {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    // WARNING - this is just the beginning of work and is not complete and has not been tested
    private class HashSetIterator implements Iterator<T> {

        int bsIndex = 0;
        Iterator<T> buckIt;

        @Override
        public boolean hasNext() {
            boolean foundBucketWithMoreElts = false;
            // find first bucket
            while (! foundBucketWithMoreElts) {
                if (bsIndex == backingStore.length)
                    return false; // no more buckets
                if (backingStore[bsIndex] == null ||  // no elts inserted in bucket
                        backingStore[bsIndex].isEmpty() ||// elts inserted in bucket but removed
                        buckIt != null && !buckIt.hasNext()) { // no more elts in bucket
                    bsIndex++;
                    buckIt = null;
                    continue;
                }
                if (buckIt == null) {
                    List bucket = backingStore[bsIndex];
                    buckIt = bucket.iterator();
                }
            }
            return buckIt != null &&  buckIt.hasNext();// in middle of iterating
        }

        @Override
        public T next() {
            return null;
        }
    }
}
