package leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

    private int amountOfHydrogens = 0;
    private Lock lock = new ReentrantLock();
    private Condition oxygenFinished = lock.newCondition();
    private Condition hydrogenFinished = lock.newCondition();

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (amountOfHydrogens == 2) {
                oxygenFinished.await();
            }
            releaseHydrogen.run();
            amountOfHydrogens++;
            hydrogenFinished.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (amountOfHydrogens < 2) {
                hydrogenFinished.await();
            }
            releaseOxygen.run();
            amountOfHydrogens = 0;
            oxygenFinished.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        Thread hydrogen1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h2O.hydrogen(() -> System.out.print("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread hydrogen2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h2O.hydrogen(() -> System.out.print("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread oxygen = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h2O.oxygen(() -> System.out.print("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hydrogen1.start();
        hydrogen2.start();
        oxygen.start();

        hydrogen1.join();
        hydrogen2.join();
        oxygen.join();
    }
}
