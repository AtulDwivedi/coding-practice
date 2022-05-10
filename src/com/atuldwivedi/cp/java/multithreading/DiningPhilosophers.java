package com.atuldwivedi.cp.java.multithreading;

/**
 * @author Atul Dwivedi
 */
public class DiningPhilosophers {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            Philosopher philosopher = null;
            if (i == philosophers.length - 1) {
                philosopher = new Philosopher(rightFork, leftFork);
            } else {
                philosopher = new Philosopher(leftFork, rightFork);
            }

            philosophers[i] = philosopher;

            Thread t = new Thread(philosopher, "Philosopher " + (i + 1));
            t.start();
        }
    }
}

class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + " Thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + " Picked left fork.");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + " Picked right fork. Eating...");
                        doAction(System.nanoTime() + " Put down right fork.");
                    }
                    doAction(System.nanoTime() + " Put down left fork. Thinking!!!");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
