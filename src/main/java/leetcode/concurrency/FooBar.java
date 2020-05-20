package leetcode.concurrency;

public class FooBar {

    private int n;
    private volatile String nextPrint = "foo";

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (nextPrint.equals("foo")) {
                    printFoo.run();
                    nextPrint = "bar";
                    break;
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (nextPrint.equals("bar")) {
                    printBar.run();
                    nextPrint = "foo";
                    break;
                }
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
