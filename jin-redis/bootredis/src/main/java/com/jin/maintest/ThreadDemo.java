package com.jin.maintest;

import sun.applet.Main;

public class ThreadDemo {

    public static void main(String[] args) {
        Num num = new Num();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    num.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    num.decre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    num.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    num.decre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Num {

    public int num = 0;

    public synchronized void incre() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        num++;
        this.notifyAll();

    }

    public synchronized void decre() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        num--;
        this.notifyAll();

    }
}
