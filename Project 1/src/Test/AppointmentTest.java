package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project1.Main.Appointment;

class AppointmentTest {

  private String id, description;
  private String idLength, descriptionLength;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
	  id = "1234567890";
	  description = "Doctor's appointment";
	  date = new Date(2023, Calendar.JULY, 15);
	  idLength = "111222333444555666";
	  descriptionLength = "Follow-up appointment after surgery to check up on recovery.";
	  pastDate = new Date(0);
	  }

  @Test
  void updateAppointmentIdTest() {
    Appointment appt = new Appointment();
    // Check that validateAndTruncateId throws an IllegalArgumentException when given a null value
    assertThrows(IllegalArgumentException.class, () -> appt.validateAndTruncateId(null));
    // Check that validateAndTruncateId throws an IllegalArgumentException when the ID is too long
    assertThrows(IllegalArgumentException.class, () -> appt.validateAndTruncateId(idLength));
    // Check that validateAndTruncateId sets the ID correctly when the input is valid
    appt.validateAndTruncateId(id);
    assertEquals(id, appt.getAppointmentId());
  }

  @Test
  void updateDateTest() {
    Appointment appt = new Appointment();
    // Check that validateDate throws an IllegalArgumentException when given a null value
    assertThrows(IllegalArgumentException.class, () -> appt.validateDate(null));
    // Check that validateDate throws an IllegalArgumentException when the date is in the past
    assertThrows(IllegalArgumentException.class, () -> appt.validateDate(pastDate));
    // Check that validateDate sets the date correctly when the input is valid
    appt.validateDate(date);
    assertEquals(date, appt.getAppointmentDate());
  }

  @Test
  void getAppointmentDateTest() {
    Appointment appt = new Appointment(id, date);
    // Check that the appointment date is not null
    assertNotNull(appt.getAppointmentDate());
    // Check that the appointment date is set correctly
    assertEquals(date, appt.getAppointmentDate());
  }

  @Test
  void updateDescriptionTest() {
    Appointment appt = new Appointment();
    // Check that validateAndTruncateDescription throws an IllegalArgumentException when given a null value
    assertThrows(IllegalArgumentException.class, () -> appt.validateAndTruncateDescription(null));
    // Check that validateAndTruncateDescription throws an IllegalArgumentException when the description is too long
    assertThrows(IllegalArgumentException.class, () -> appt.validateAndTruncateDescription(descriptionLength));
    // Check that validateAndTruncateDescription sets the description correctly when the input is valid
    appt.validateAndTruncateDescription(description);
    assertEquals(description, appt.getDescription());
  }

  @Test
  void testGetDescription() {
    Appointment appt = new Appointment(id, date, description);
    // Test that the description returned is not null
    assertNotNull(appt.getDescription());
    // Test that the length of the description is less than or equal to 50 characters
    assertTrue(appt.getDescription().length() <= 50, "Description length should not be more than 50 characters");
    // Test that the returned description is equal to the expected value
    assertEquals(description, appt.getDescription(), "Returned description does not match expected value");
  }
}