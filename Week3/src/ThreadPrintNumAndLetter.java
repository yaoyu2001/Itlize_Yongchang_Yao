import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintNumAndLetter {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(print::printNum).start();

        new Thread(print::printZimu).start();

    }
}

 class Print {
    final Lock lock = new ReentrantLock();
    final Condition num = lock.newCondition();
    final Condition zimu = lock.newCondition();


    public void printNum(){
        lock.lock();
        try {
            for (int i=1;i<53;i++){
                System.out.print(i);
                if (i%2==0){
                    zimu.signal();
                    num.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printZimu(){
        lock.lock();
        try {
            for (int i=0;i<26;i++){
                System.out.print((char)(i+'A'));
                num.signal();
                zimu.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
