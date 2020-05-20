package leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

    private String nextCall = "first";
    private Lock lock = new ReentrantLock();
    private Condition first = lock.newCondition();
    private Condition second = lock.newCondition();
    private Condition third = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (!nextCall.equals("first")) {
                first.await();
            }
            printFirst.run();
            nextCall = "second";
            second.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!nextCall.equals("second")) {
                second.await();
            }
            printSecond.run();
            nextCall = "third";
            third.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!nextCall.equals("third")) {
                third.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
        Thread first = new Thread(() -> {
            try {
                printInOrder.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread second = new Thread(() -> {
            try {
                printInOrder.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread third = new Thread(() -> {
            try {
                printInOrder.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        third.start();
        first.start();
        second.start();

        first.join();
        second.join();
        third.join();
    }
}
