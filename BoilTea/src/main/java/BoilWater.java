public class BoilWater extends Thread{
    @Override
    public void run() {
        System.out.println("开始烧水....");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("水开了...");
    }
}
