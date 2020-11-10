class PrintLetter {

    private boolean should_a = true;
    private boolean should_b = false;
    private boolean should_c = false;

    public synchronized void print_A () {
        while(should_b || should_c) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("A");
        should_a = false;
        should_b = true;
        should_c = false;
        this.notifyAll();
    }

    public synchronized void print_B () {
        while(should_a || should_c) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("B");
        should_a = false;
        should_b = false;
        should_c = true;
        this.notifyAll();
    }

    public synchronized void print_C () {
        while(should_a || should_b) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("C");
        should_a = true;
        should_b = false;
        should_c = false;
        this.notifyAll();
    }
}

public class ThreadPrintABC {

    public static void main(String[] args) {

        final PrintLetter print_letter = new PrintLetter();
        
        Thread thread_a = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10;i++) {
                    print_letter.print_A();
                }
            }
        });
        thread_a.start();

        Thread thread_b = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10;i++) {
                    print_letter.print_B();
                }
            }
        });
        thread_b.start();

        Thread thread_c = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10;i++) {
                    print_letter.print_C();
                }
            }
        });
        thread_c.start();

    }
}

