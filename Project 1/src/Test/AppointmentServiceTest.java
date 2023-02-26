package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project1.Main.Appointment;
import Project1.Main.AppointmentService;

class AppointmentServiceTest {
	private String id, description, descriptionLength;
	private Date date, pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		id = "1234567890";
		description = "Doctor's appointment";
		date = new Date(2023, Calendar.JULY, 15);
		descriptionLength = "Follow-up appointment after surgery to check up on recovery.";
		pastDate = new Date(0);
	}

	@Test
	void newAppointmentTest() {
		AppointmentService service = new AppointmentService();

		// Test creating an appointment with no parameters
		service.newAppointment();
		Appointment appointment1 = service.getAppointmentList().get(0);
		assertNotNull(appointment1.getAppointmentId());
		assertNotNull(appointment1.getAppointmentDate());
		assertNotNull(appointment1.getDescription());

		// Test creating an appointment with a date parameter
		service.newAppointment(date);
		Appointment appointment2 = service.getAppointmentList().get(1);
		assertNotNull(appointment2.getAppointmentId());
		assertEquals(date, appointment2.getAppointmentDate());
		assertNotNull(appointment2.getDescription());

		// Test creating an appointment with a date and description parameter
		service.newAppointment(date, description);
		Appointment appointment3 = service.getAppointmentList().get(2);
		assertNotNull(appointment3.getAppointmentId());
		assertEquals(date, appointment3.getAppointmentDate());
		assertEquals(description, appointment3.getDescription());

		// Check that appointment IDs are unique
		assertNotEquals(appointment1.getAppointmentId(), appointment2.getAppointmentId());
		assertNotEquals(appointment1.getAppointmentId(), appointment3.getAppointmentId());
		assertNotEquals(appointment2.getAppointmentId(), appointment3.getAppointmentId());

		// Test creating an appointment with a past date
		assertThrows(IllegalArgumentException.class, () -> service.newAppointment(pastDate));
		// Test creating an appointment with a too long description
		assertThrows(IllegalArgumentException.class, () -> service.newAppointment(date, descriptionLength));
	}

	@Test
	void deleteAppointmentTest() throws Exception {
		// create an instance of the AppointmentService class
		AppointmentService service = new AppointmentService();

		// create 3 appointments
		service.newAppointment();
		service.newAppointment();
		service.newAppointment();

		// store the ids of the appointments
		String firstId = service.getAppointmentList().get(0).getAppointmentId();
		String secondId = service.getAppointmentList().get(1).getAppointmentId();
		String thirdId = service.getAppointmentList().get(2).getAppointmentId();

		// check that the ids are different from each other and from id
		assertNotEquals(firstId, secondId);
		assertNotEquals(firstId, thirdId);
		assertNotEquals(secondId, thirdId);
		assertNotEquals(id, firstId);
		assertNotEquals(id, secondId);
		assertNotEquals(id, thirdId);

		// check that trying to delete an appointment with an unknown id throws an
		// exception
		assertThrows(Exception.class, () -> service.deleteAppointment(id));

		// delete the first appointment
		service.deleteAppointment(firstId);
		// check that trying to delete the same appointment again throws an exception
		assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
		// check that the first appointment has been deleted and replaced by a different
		// appointment
		assertNotEquals(firstId, service.getAppointmentList().get(0).getAppointmentId());
	}
}