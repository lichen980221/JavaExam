import java.util.Scanner;

public class Bank extends Thread{
    Account account;
    Object obj;
    Scanner sc;
    public Bank(Account account,Object obj){
        sc=new Scanner(System.in);
        this.account=account;
        this.obj=obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            while(account.getMoney()>0){
                System.out.println("请到"+Thread.currentThread().getName()+"取钱");
                System.out.println("请输入您要提取的金额:");
                double drawMoney = sc.nextDouble();
                if (account.getMoney()<drawMoney)
                    System.out.println("余额不足...您的余额为"+account.getMoney());
                else{
                    account.draw(drawMoney);
                    System.out.println("取款成功，成功取出"+drawMoney+"元，您的余额为"+account.getMoney());
                    break;
                }
            }
        }
    }
}
