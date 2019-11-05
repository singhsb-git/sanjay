package com.san.analytical;


import java.util.Iterator;

public class FilteringIterator implements Iterator<Object> {
    private  Iterator<Object> wrapped = null;
    private  IObjectTest predicate  = null;
    private Object next;

    FilteringIterator(Iterator<Object> wrapped, IObjectTest predicate) {
        this.wrapped = wrapped;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while (next == null && wrapped.hasNext()) {
            next = wrapped.next();
            if (predicate.test(next))
                return true;
            next = null;
        }
        return next != null;
    }

    @Override
    public Object next() {
        if (next == null)
            hasNext();
        try {
            return next;
        } finally {
            next = null;
            hasNext();
        }
    }

    @Override
    public void remove() {
        wrapped.remove();
    }
}