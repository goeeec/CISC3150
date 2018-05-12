public class Alphabet {

    volatile int count = 0;

    public static void main(String[] args) throws Throwable {
        Alphabet abc = new Alphabet();

        Thread t1 = new Thread(new A(abc));
        Thread t2 = new Thread(new B(abc));
        Thread t3 = new Thread(new C(abc));
        Thread t4 = new Thread(new D(abc));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.print("\n");
    }

}

class A implements Runnable {
    char letter = 'a';
    Alphabet pos;

    A(Alphabet pos) {
        this.pos = pos;
    }

    public void run() {
        while (letter <= 'z') {
            if (pos.count != 0) {
                try {
                    wait();
                } catch (Throwable t) {}
            } else {
                System.out.printf("%c ", this.letter);
                letter += 4;
                synchronized (pos) {
                    pos.count = 1;
                    try {
                        notifyAll();
                    } catch (Throwable t) {}
                }
            }
        }
    }
}

class B implements Runnable {
    char letter = 'b';
    Alphabet pos;

    B(Alphabet pos) {
        this.pos = pos;
    }

    public void run() {
        while (letter <= 'z') {
            if (pos.count != 1) {
                try {
                    wait();
                } catch (Throwable t) {}
            } else {
                System.out.printf("%c ", this.letter);
                letter += 4;
                synchronized (pos) {
                    pos.count = 2;
                    try {
                        notifyAll();
                    } catch (Throwable t) {}
                }
            }
        }
    }
}

class C implements Runnable {
    char letter = 'c';
    Alphabet pos;

    C(Alphabet pos) {
        this.pos = pos;
    }

    public void run() {
        while (letter <= 'z') {
            if (pos.count != 2) {
                try {
                    wait();
                } catch (Throwable t) {}
            } else {
                System.out.printf("%c ", this.letter);
                letter += 4;
                synchronized (pos) {
                    pos.count = 3;
                    try {
                        notifyAll();
                    } catch (Throwable t) {}
                }
            }
        }
    }
}

class D implements Runnable {
    char letter = 'd';
    Alphabet pos;

    D(Alphabet pos) {
        this.pos = pos;
    }

    public void run() {
        while (letter <= 'z') {
            if (pos.count != 3) {
                try {
                    wait();
                } catch (Throwable t) {}
            } else {
                System.out.printf("%c ", this.letter);
                letter += 4;
                synchronized (pos) {
                    pos.count = 0;
                    try {
                        notifyAll();
                    } catch (Throwable t) {}
                }
            }
        }
    }
}

/*
Reference:
https://stackoverflow.com/questions/43176198/multithreading-in-java-to-print-abc-using-3-threads?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
And blah.java in HW9
*/