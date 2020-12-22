package demo.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class SellTicketBySync implements Runnable {
    /**
     * 剩余的票数
     */
    private volatile AtomicInteger ticket = new AtomicInteger(500);

    @Override
    public void run() {
        while (true) {
            if (this.ticket.get() > 0) {
                SellTicket();
            } else {
                break;
            }
        }
    }

    public void SellTicket() {
        int i = this.ticket.get();
        if (i > 0) {
            try {
                //线程休眠50毫秒
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName() + "出售第" + i + "张车票");
                this.ticket.decrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        //创建一个Runnable实例
        SellTicketBySync sellTicketBySync = new SellTicketBySync();
        //创建3条线程，并为3条线程指定名称
        Thread thread01 = new Thread(sellTicketBySync,"窗口1");
        Thread thread02 = new Thread(sellTicketBySync,"窗口2");
        Thread thread03 = new Thread(sellTicketBySync,"窗口3");
        thread01.start();
        thread02.start();
        thread03.start();
    }

}