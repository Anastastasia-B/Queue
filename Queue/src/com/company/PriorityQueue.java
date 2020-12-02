package com.company;

class PriorityQueue {
    private Data head = null;
    private long size = 0L;

    void insert(Data data) {
        if (this.head == null) {
            this.head = data;
        } else {
            Data curr = this.head;
            if (data.getValue() >= this.head.getValue()) {
                data.next = this.head;
                this.head = data;
            } else {
                Data prev;
                for(prev = curr; curr != null && data.getValue() < curr.getValue(); curr = curr.next) {
                    prev = curr;
                }

                data.next = curr;
                prev.next = data;
            }
        }

        ++this.size;
    }

    Data[] extract(long toExtract) {
        Data[] toReturn;
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

    Data find(int value) {
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

