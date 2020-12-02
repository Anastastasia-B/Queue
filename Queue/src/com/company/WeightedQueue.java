package com.company;

class WeightedQueue {
    private Data head = null;
    private Data last = null;
    private long size = 0L;
    private final long capacity;

    WeightedQueue(long capacity) {
        this.capacity = capacity;
    }

    void pushBack(Data data) {
        if (this.head == null) {
            this.head = data;
        } else {
            this.last.next = data;
        }

        this.last = data;
        ++this.size;
    }

    Data[] extract(long fullCapacity) {
        Data[] toReturn;
        long toExtract = fullCapacity * this.capacity / 100L;
        if (this.size < toExtract) {
            toReturn = new Data[(int)this.size];
        } else {
            toReturn = new Data[(int)toExtract];
        }

        for(int ind = 0; ind != toReturn.length; ++ind) {
            Data temp = this.head;
            this.head = this.head.next;
            temp.next = null;
            toReturn[ind] = temp;
        }

        this.size -= toReturn.length;
        return toReturn;
    }

    Data find(long value) {
        for(Data curr = this.head; curr != null; curr = curr.next) {
            if(curr.getValue() == value)
                return curr;
        }
        return null;
    }

    long getSize() {
        return this.size;
    }
}
