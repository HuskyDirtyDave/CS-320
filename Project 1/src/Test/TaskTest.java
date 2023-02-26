package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;
import Project1.Main.Task;

public class TaskTest {
	@Test
	public void testValidTask() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		assertEquals("123", task.getId());
		assertEquals("Test Task", task.getName());
		assertEquals("This is a test task.", task.getDescription());
	}

	@Test
	public void testSetName() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		task.setName("New Name");
		assertEquals("New Name", task.getName());
	}

	@Test
	public void testSetDescription() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		task.setDescription("New Description");
		assertEquals("New Description", task.getDescription());
	}

	@Test
	public void testNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "This is a test task.");
        });
    }

	@Test
	public void testEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> new Task("123", "", "This is a test task."));
	}

	@Test
	public void testEmptyDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("123", "Test Task", "");
		});
	}

	@Test
	public void testSetNameNull() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}

	@Test
	public void testSetDescriptionNull() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}

	@Test
	public void testSetNameTooLong() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("This name is too long");
		});
	}

	@Test
	public void testSetDescriptionTooLong() {
	    Task task = new Task("123", "Test Task", "This is a test task.");
	    assertThrows(IllegalArgumentException.class, () -> {
	        task.setDescription("This description is too long for a test task, The task description can't exceed 50 characters.");
	    });
	}

	@Test
	public void testGetters() {
		Task task = new Task("123", "Test Task", "This is a test task.");
		assertEquals("123", task.getId());
		assertEquals("Test Task", task.getName());
		assertEquals("This is a test task.", task.getDescription());
	}
}