package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Project1.Main.Task;
import Project1.Main.TaskService;

public class TaskServiceTest {
    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task.");
        service.addTask(task);
        assertEquals(1, service.getTasks().size());
    }

    @Test
    public void testAddTaskWithExistingId() {
        TaskService service = new TaskService();
        Task task1 = new Task("123", "Test Task 1", "This is a test task.");
        Task task2 = new Task("123", "Test Task 2", "This is another test task.");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
        assertEquals(1, service.getTasks().size());
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task.");
        service.addTask(task);
        service.deleteTask("123");
        assertEquals(0, service.getTasks().size());
    }

    @Test
    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task.");
        service.addTask(task);
        service.updateTaskName("123", "New Name");
        assertEquals("New Name", service.getTask("123").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task.");
        service.addTask(task);
        service.updateTaskDescription("123", "New Description");
        assertEquals("New Description", service.getTask("123").getDescription());
    }
}