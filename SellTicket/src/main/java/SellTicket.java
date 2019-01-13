
class TicketOffice implements Runnable{
    Object obj;
    int ticketCount;
    public TicketOffice(Object obj,int ticketCount){
        this.obj=obj;
        this.ticketCount=ticketCount;
    }

    public void run() {
        while (ticketCount>=0){
            synchronized (obj) {
                if (ticketCount == 0) {
                    System.out.println("票已售空...");
                    break;
                } else {
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "售点出售票券，还有" + ticketCount + "张票");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
public class SellTicket {
    public static void main(String[] args) {
        TicketOffice ticketOffice=new TicketOffice("中国高铁",1000);
        new Thread(ticketOffice,"天津高铁").start();
        new Thread(ticketOffice,"北京高铁").start();
        new Thread(ticketOffice,"重庆高铁").start();
      /*  Thread thread = new Thread(ticketOffice);
        thread.setName("天津高铁");
        thread.start();*/
    }
}
