package demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class demo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());


        ScheduledExecutorService newScheduledThreadPool =
                Executors.newScheduledThreadPool(4,threadPoolExecutor.getThreadFactory());



    }
}
