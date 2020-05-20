package leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

    private int n;
    private String nextPrint = "foo";
    private Lock lock = new ReentrantLock();
    private Condition foo = lock.newCondition();
    private Condition bar = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!nextPrint.equals("foo")) {
                    foo.await();
                }
                printFoo.run();
                nextPrint = "bar";
                bar.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!nextPrint.equals("bar")) {
                    bar.await();
                }
                printBar.run();
                nextPrint = "foo";
                foo.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(2);
        Thread foo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(() -> System.out.print("foo"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread bar = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(() -> System.out.print("bar"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        foo.start();
        bar.start();

        foo.join();
        bar.join();
    }
}
