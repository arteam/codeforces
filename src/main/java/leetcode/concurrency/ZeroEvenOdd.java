package leetcode.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    private String nextCall = "zero";
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                if (counter >= n) {
                    break;
                }
                if (nextCall.equals("zero")) {
                    printNumber.accept(0);
                    nextCall = counter % 2 == 0 ? "odd" : "even";
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                if (counter >= n) {
                    break;
                }
                if (nextCall.equals("even")) {
                    printNumber.accept(++counter);
                    nextCall = "zero";
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                if (counter >= n) {
                    break;
                }
                if (nextCall.equals("odd")) {
                    printNumber.accept(++counter);
                    nextCall = "zero";
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread zero = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(i -> {
                        if (i == 0) {
                            System.out.print(i);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(i -> {
                        if (i > 0 && i % 2 == 0) {
                            System.out.print(i);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(i -> {
                        if (i > 0 && i % 2 != 0) {
                            System.out.print(i);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        zero.start();
        even.start();
        odd.start();

        zero.join();
        even.join();
        odd.join();

    }
}
