package org.example;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<String> list = new CopyOnWriteArrayList<>();

        Runnable addProduct = () -> {
            for (int i = 0; i < 10; i++) {
                list.add("Product-" + i);
            }
            System.out.println("List finale des produits : "+Thread.currentThread().getName()+list);
        };

        Thread thread1 = new Thread(addProduct);
        Thread thread2 = new Thread(addProduct);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();





    }
}