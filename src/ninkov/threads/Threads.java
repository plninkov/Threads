package ninkov.threads;

public class Threads {
    public static void main(String[] args) {
        Runnable hello = new DisplayMessage("Hello!");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Starting hello thread, in new branch");
        thread1.start();
/*
        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Starting goodbye thread...");
        thread2.start(); */

        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.setName("Thread 27");
        thread3.setPriority(7);
        thread3.start();
        try {
            thread3.join();
            System.out.println("** joined Thread 27**");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Starting thread4...");
        Thread thread4 = new GuessANumber(75);
        thread4.setName("Thread 75");
        thread4.start();

    }
}
