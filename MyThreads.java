
public class MyThreads {

    public static void main(String[] args) {

        Object train = new Object();
        Object comp = new Object();

        BookTicket obj1 = new BookTicket(train, comp);
        CancelTicket obj2 = new CancelTicket(train, comp);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();




        // Reserve obj = new Reserve(1);
        // Thread t1 = new Thread(obj , "FirstPerson");
        // Thread t2 = new Thread(obj , "SecondPerson");
        // Thread t3 = new Thread(obj , "ThirdPerson");
        // Thread t4 = new Thread(obj , "fourthPerson");
        // Thread t5 = new Thread(obj , "fifthPerson");
        // t1.start();
        // t2.start();
        // t3.start();
        // t4.start();
        // t5.start();





        // MyThread obj1 = new MyThread("Cut the ticket");
        // MyThread obj2 = new MyThread("Show the seat");   
        // Thread t1 = new Thread(obj1);
        // Thread t2 = new Thread(obj2);
        // t1.start();
        // t2.start();
        
        
        // System.out.println("Let us find current thread");
        // Thread t = Thread.currentThread();
        // System.out.println("Current thread is " + t);
        // System.out.println(t.getName());
        
        
        
    }
}
class BookTicket implements Runnable{
    Object train , comp ;
    BookTicket(Object train , Object comp){
        this.train = train;
        this.comp = comp;
    }
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        synchronized(train){
            System.out.println("Book ticket locked on train");
            try{
                Thread.sleep(140);

            }catch(Exception e){

            }
            System.out.println("Book ticket is now waiting to lock on compartment");
            synchronized(comp){
                System.out.println("BookTicket locked on compartment");
            }
        }
    }
}
class CancelTicket implements Runnable{
    Object train , comp;
    CancelTicket(Object train , Object comp){
        this.train = train;
        this.comp = comp;
    }
    public void run(){
        
        synchronized(comp){
            System.out.println("cancelticket locked on compartment");
            try{
                Thread.sleep(20);
            }catch(Exception e){

            }
            System.out.println("CancelTicket now waiting to lock on train");

            synchronized(train){
                System.out.println("cancelTicket is locked on train ");
            }
        }
    }
}
class Reserve implements Runnable{
    int available = 4;
    int wanted;
    Reserve(int i){
        wanted = i;
    }
    public void run(){
        synchronized(this){
            System.out.println("Available berths are " + available);
            if(available >= wanted){
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
    
                }
                available -= wanted;
                System.out.println("One berth is reserved for " + Thread.currentThread().getName());
                System.out.println("now available berth is " + available);
            }else{
                System.out.println("No berth is available");
            }

        }
    }
}

class MyThread extends Thread{
    String str;
    MyThread(String str){
        this.str = str;
    }
    public void run(){
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(str + " " + i);
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}