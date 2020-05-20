package leetcode.concurrency;

public class PrintInOrder {

    private volatile String nextCall = "first";

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            if (nextCall.equals("first")) {
                printFirst.run();
                nextCall = "second";
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (nextCall.equals("second")) {
                printSecond.run();
                nextCall = "third";
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (nextCall.equals("third")) {
                printThird.run();
                nextCall = "first";
                break;
            }
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
