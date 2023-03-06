package _framework;

import java.util.concurrent.Executor;

public final class TaskExecutor implements Executor {

    private final static TaskExecutor executor = new TaskExecutor(); //eager

    private TaskExecutor(){
        super();
    }

    public synchronized static TaskExecutor getInstance(){
        return executor;
    }

    @Override
    public synchronized void execute(Runnable task) {
        task.run();
    }
}
