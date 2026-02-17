package edu.touro.las.mcon364.taskmanager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public Map<Priority, List<Task>> getTasksByPriority() {
        Map<String, Task> tasksByName = registry.getAll();
        Map<Priority, List<Task>> tasksByPriority = new HashMap<>();
        for (Priority priority : Priority.values()) {
            tasksByPriority.put(priority, new LinkedList<Task>());
        }
        for (Map.Entry<String, Task> entry : tasksByName.entrySet()) {
            Task task = entry.getValue();
            tasksByPriority.get(entry.getValue().priority()).add(task);
        }
        return tasksByPriority;
    }
}
