package leetcode.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private AtomicInteger counter = new AtomicInteger(1);
    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) {
                break;
            }
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                counter.incrementAndGet();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) {
                break;
            }
            if (i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
                counter.incrementAndGet();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) {
                break;
            }
            if (i % 15 == 0) {
                printFizzBuzz.run();
                counter.incrementAndGet();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) {
                break;
            }
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread fizz = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizz(() -> System.out.print("fizz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread buzz = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.buzz(() -> System.out.print("buzz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread fizzbuzz = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread number = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();


        fizz.join();
        buzz.join();
        fizzbuzz.join();
        number.join();
    }
}
