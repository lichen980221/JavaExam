public class TestBoil {
    public static void main(String[] args) {
        WashCup washCup = new WashCup();
        BoilWater boilWater = new BoilWater();
        boilWater.setPriority(Thread.MAX_PRIORITY);

        boilWater.start();
        washCup.start();
    }
}
