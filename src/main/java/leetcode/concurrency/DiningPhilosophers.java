package leetcode.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private ReentrantLock waiter = new ReentrantLock();

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        waiter.lock();
        try {
            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();
        } finally {
            waiter.unlock();
        }
    }

}
