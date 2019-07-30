package com.sunkaisens.androidutils;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:sjy
 * @date:2019-07-22
 * @email:sjy_mail@163.com
 * @Description:
 */
public class TimerUtil {
    private static volatile TimerUtil mInstance;
    private final ScheduledThreadPoolExecutor executor;

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));

    private TimerUtil() {

        BasicThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("TimerUtils").daemon(true).build();
        executor = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE, threadFactory);
    }

    public static TimerUtil getInstance() {
        if (mInstance == null) {
            synchronized (TimerUtil.class) {
                if (mInstance == null) {
                    mInstance = new TimerUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 执行定时器
     *
     * @param runnable     线程
     * @param initialDelay 延迟执行时间
     * @param period       执行的时间间隔
     */
    public void startTimer(Runnable runnable, long initialDelay, long period) {
        executor.scheduleAtFixedRate(runnable, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    /**
     * 取消定时器
     */
    public void cancel() {
        executor.shutdown();
    }

    /**
     * 开启一个线程
     *
     * @param runnable 线程
     */
    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }

    public void remove(Runnable runnable) {

        BlockingQueue<Runnable> queue = executor.getQueue();

        int i = runnable.hashCode();
        System.out.println("i = " + i);

        for (Runnable runnable1 : queue) {
            System.out.println("runnable1 = " + runnable1.hashCode());
        }
    }

    /**
     * 延时执行一个线程
     *
     * @param runnable 线程
     * @param delay    延时时间
     */
    public void schedule(Runnable runnable, long delay) {
        executor.schedule(runnable, delay, TimeUnit.MILLISECONDS);
    }
}
