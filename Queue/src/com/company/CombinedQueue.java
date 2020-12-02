package com.company;

public class CombinedQueue {
    private PriorityQueue PQ;
    private WeightedQueue[] WQ = new WeightedQueue[3];
    private final long dataFlow = 100L;
    private final long wqCapacity = 30L;
    private final long pqCapacity = 70L;
    private final long wqNumber = 3;

    CombinedQueue() {
        this.WQ[0] = new WeightedQueue(10L);
        this.WQ[1] = new WeightedQueue(20L);
        this.WQ[2] = new WeightedQueue(30L);
        this.PQ = new PriorityQueue();
    }

    void insert(Data data) {
        String type = data.getType();
        if ("Т1".equals(type)) {
            this.WQ[0].pushBack(data);
        } else if ("Т2".equals(type)) {
            this.WQ[1].pushBack(data);
        } else if ("Т3".equals(type)) {
            this.WQ[2].pushBack(data);
        } else if ("ЧЗТ".equals(type)) {
            this.PQ.insert(data);
        } else {
            System.out.println("Несуществующий тип данных! Элемент " + data.getValue() + " проигнорирован");
        }
    }

    void process() {
        long fullCapacity = Math.round(60.0D);
        Data[] fromWQ0 = this.WQ[0].extract(fullCapacity);
        Data[] fromWQ1 = this.WQ[1].extract(fullCapacity);
        Data[] fromWQ2 = this.WQ[2].extract(fullCapacity);
        Data[] fromPQ = this.PQ.extract(Math.round(40.0D));
        this.printData("ВО1", fromWQ0);
        this.printData("ВО2", fromWQ1);
        this.printData("ВО3", fromWQ2);
        this.printData("ПО", fromPQ);
    }

    private void printData(String arrType, Data[] arr) {
        if (arr.length == 0) {
            System.out.println("Ничего не было удаленио из " + arrType);
        } else {
            System.out.print("Удалено из " + arrType + ": ");

            for (Data data : arr) {
                System.out.print(data.getValue() + " ");
            }

            System.out.println();
        }
    }

    void find(int value) {
        boolean found = false;
        for(int i = 0; i < 3; ++i) {
            Data res = this.WQ[i].find(value);
            if (res != null) {
                res.print();
                found = true;
            }
        }
        Data rez = this.PQ.find(value);
        if (rez != null) {
            rez.print();
            found = true;
        }
        if(!found)
            System.out.println("Элемент не найден.");
    }

    boolean isEmpty() {
        return this.WQ[0].getSize() == 0L && this.WQ[1].getSize() == 0L && this.WQ[2].getSize() == 0L && this.PQ.getSize() == 0L;
    }

}
