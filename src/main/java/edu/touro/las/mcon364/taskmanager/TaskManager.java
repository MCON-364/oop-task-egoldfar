package edu.touro.las.mcon364.taskmanager;

public class TaskManager {

    private final TaskRegistry registry;

    public TaskManager(TaskRegistry registry) {
        this.registry = registry;
    }

    public void run(Command command) {
        switch (command) {
            case AddTaskCommand a -> command.execute();
            case RemoveTaskCommand r -> command.execute();
            case UpdateTaskCommand u -> command.execute();
            default -> throw new IllegalArgumentException("Unknown command type");
        }
    }
}
