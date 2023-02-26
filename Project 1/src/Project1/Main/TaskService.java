package Project1.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;


public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getId(), task);
    }

    public void deleteTask(String id) {
        tasks.remove(id);
    }

    public void updateTaskName(String id, String name) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setName(name);
            tasks.put(id, task);
        }
    }

    public void updateTaskDescription(String id, String description) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setDescription(description);
            tasks.put(id, task);
        }
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }
}