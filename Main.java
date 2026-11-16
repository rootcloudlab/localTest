package localTest;


class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread class is running");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1: " + i);
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable interface is running");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 2: " + i);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // 1. Main Thread
        System.out.println("Main Thread Started");

        // 2. Creating thread using Thread class
        MyThread t1 = new MyThread();
        t1.start();

        // 3. Creating thread using Runnable interface
        MyRunnable obj = new MyRunnable();
        Thread t2 = new Thread(obj);
        t2.start();

        // 4. Thread Priority
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Thread 1 Priority: "
                + t1.getPriority());

        System.out.println("Thread 2 Priority: "
                + t2.getPriority());

        // 5. Sleep method
        try {
            Thread.sleep(1000);
            System.out.println("Main thread slept for 1 second");
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

        // 6. Join method
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main Thread Finished");
    }
}
