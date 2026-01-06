package findjob.taskqueue;

public class TaskQueueExample {
    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue(3, 100);
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            taskQueue.addTask(() -> {
                System.out.println(" 任务 开始执行  " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" 任务 完成执行  " + taskId);
            });
        }
    }
}
