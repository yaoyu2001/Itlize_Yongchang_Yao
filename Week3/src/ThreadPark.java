// Parking cars
class Park implements Runnable{ //Park class
    private ThreadPark pl;
    public Park(ThreadPark pl){
        this.pl = pl;
    }
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(1000);//Time out to indicate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pl.park();
        }
    }
}

class Drive implements Runnable{//Drive away class
    private ThreadPark pl;
    public Drive(ThreadPark pl){
        this.pl = pl;
    }
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(1000);//Time out to indicate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pl.drive();
        }
    }
}

public class ThreadPark {
    // True means current position is available
    boolean[] sites = {true,true,true};

    // If
    private boolean isFull(){
        int e=0;
        for(int i=0;i<3;i++){
            if(!sites[i])
                e++;
        }
        return e==3;
    }

    private boolean isEmpty(){
        int e=0;
        for (int i = 0; i < 3; i++) {
            if(sites[i])
                e++;
        }
        return e==3;
    }

    private int whichIsEmpty(){
        for(int i=0;i<3;i++)
            if(sites[i])
                return i;
        return -1;
    }

    private int whichIsFull(){
        for(int i=0;i<3;i++)
            if(!sites[i])
                return i;
        return -1;
    }

    public synchronized void park(){
        if(isFull()){
            try {
                System.out.println("Position Full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            int num = whichIsEmpty();
            System.out.println("Park car ! "+Thread.currentThread().getName() + " Parking at " + num + " Position");
            sites[num] = false;
            notifyAll();
        }
    }

    public synchronized void drive(){
        if(isEmpty()){
            try {
                System.out.println("Position Empty！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            int num = whichIsFull();
            System.out.println("Drive car away ! "+Thread.currentThread().getName()+" drive car in "+num+" position away ");
            sites[num] = true;
            notifyAll();
        }
    }
    public static void main(String[] args) {
        ThreadPark pl = new ThreadPark();
        Park p = new Park(pl);
        Drive d = new Drive(pl);
        Thread t1 = new Thread(p, "Car1");
        Thread t2 = new Thread(p, "Car2");
        Thread t3 = new Thread(p, "Car3");
        Thread d1 = new Thread(d, "Driver");


            t1.start();
            t2.start();
            t3.start();
            d1.start();



    }
}





