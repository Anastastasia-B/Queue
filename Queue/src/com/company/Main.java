package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CombinedQueue cQ = new CombinedQueue();

        Scanner scan = new Scanner(System.in);
        boolean escape = false;
        while(!escape){
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Меню:\nАвтозаполнение  -  нажмите 1\nДобавление  -  нажмите 2\nПоиск  -  нажмите 3\n" +
                    "Удаление  -  нажмите 4\nЗавершить работу  -  нажмите 5");
            System.out.println("-----------------------------------------------------------------------------");
            switch (scan.nextInt()){
                case 1:
                    Random rand = new Random();
                    for(int i = 0; i < 500; ++i) {
                        int info = rand.nextInt(200);
                        int type = rand.nextInt(4);
                        switch (type){
                            case 0:
                                cQ.insert(new Data(info, "Т1"));
                                break;
                            case 1:
                                cQ.insert(new Data(info, "Т2"));
                                break;
                            case 2:
                                cQ.insert(new Data(info, "Т3"));
                                break;
                            case 3:
                                cQ.insert(new Data(info, "ЧЗТ"));
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите тип нового элемента (T1, T2, T3, ЧЗТ): ");
                    Scanner sScan = new Scanner(System.in);
                    String type = sScan.nextLine();
                    System.out.println("Введите значение нового элемента: ");
                    int value = scan.nextInt();
                    cQ.insert(new Data(value, type));
                    break;
                case 3:
                    System.out.println("Введите значение элемента для поиска: ");
                    int val = scan.nextInt();
                    cQ.find(val);
                    break;
                case 4:
                    while(!cQ.isEmpty()) {
                        cQ.process();
                    }
                    break;
                case 5:
                    escape = true;
            }
        }

    }
}
