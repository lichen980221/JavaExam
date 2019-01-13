public class WashCup extends Thread{
    @Override
    public void run() {
        for (int i=0;i<5;){
            System.out.println("洗第"+ ++i +"个杯子");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
