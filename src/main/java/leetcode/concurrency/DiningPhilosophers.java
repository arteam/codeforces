package leetcode.concurrency;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiningPhilosophers {

    private List<ReentrantLock> forks = IntStream.range(0, 5)
            .mapToObj(i -> new ReentrantLock(true))
            .collect(Collectors.toList());

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        ReentrantLock left = forks.get(philosopher % 5);
        ReentrantLock right = forks.get((philosopher + 1) % 5);

        if (philosopher < 4) {
            left.lock();
            right.lock();
        } else {
            right.lock();
            left.lock();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putRightFork.run();
        putLeftFork.run();

        left.unlock();
        right.unlock();
    }
}