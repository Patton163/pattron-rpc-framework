package thread;

import java.util.concurrent.*;

/**
 * 固定线程池管理器
 *
 * @Author: huyibo
 * @Date: 2021/6/6
 */
public class ThreadPoolManager {

    private static final ThreadPoolExecutor fixExecutor = new ThreadPoolExecutor(16, 16, 60,
            TimeUnit.HOURS, new LinkedBlockingQueue<>(3));

    /**
     * 任务提交
     *
     * @param task
     * @param <T>
     * @return
     */
    public static <T> Future<T> sub(Callable<T> task) {
        return fixExecutor.submit(task);
    }

    public static ThreadPoolExecutor getExecutor() {
        return fixExecutor;
    }

}
