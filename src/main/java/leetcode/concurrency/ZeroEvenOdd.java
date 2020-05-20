package leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    private String nextCall = "zero";
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!nextCall.equals("zero")) {
                    zero.await();
                }
                printNumber.accept(0);
                if (i % 2 == 0) {
                    nextCall = "odd";
                    odd.signal();
                } else {
                    nextCall = "even";
                    even.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (!nextCall.equals("even")) {
                    even.await();
                }
                printNumber.accept(i);
                nextCall = "zero";
                zero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (!nextCall.equals("odd")) {
                    odd.await();
                }
                printNumber.accept(i);
                nextCall = "zero";
                zero.signal();
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
