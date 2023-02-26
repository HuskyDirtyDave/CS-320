package Project1.Main;

import java.util.Date;

public class Appointment {
	private static final byte APPOINTMENT_ID_LENGTH = 10;
	private static final byte APPOINTMENT_DESCRIPTION_LENGTH = 50;
	private static final String INITIALIZER = "INITIAL";

	private String appointmentId;
	private Date appointmentDate;
	private String description;

	/**
	 * Default constructor for creating a new appointment instance. Initializes the
	 * appointment id, appointment date and description with "INITIAL" value.
	 */
	public Appointment() {
		Date today = new Date();
		appointmentId = INITIALIZER;
		appointmentDate = today;
		description = INITIALIZER;
	}

	/**
	 * Parametrized constructor for creating a new appointment instance with
	 * appointment id. Initializes the appointment id, appointment date with the
	 * given id and "INITIAL" value respectively.
	 * 
	 * @param id the appointment id
	 */
	public Appointment(String id) {
		Date today = new Date();
		appointmentId = validateAndTruncateId(id);
		appointmentDate = validateDate(today);
		description = INITIALIZER;
	}

	/**
	 * Parametrized constructor for creating a new appointment instance with
	 * appointment id and date. Initializes the appointment id, appointment date
	 * with the given id and date respectively.
	 * 
	 * @param id   the appointment id
	 * @param date the appointment date
	 */
	public Appointment(String id, Date date) {
		appointmentId = validateAndTruncateId(id);
		appointmentDate = validateDate(date);
		description = INITIALIZER;
	}

	/**
	 * Parametrized constructor for creating a new appointment instance with
	 * appointment id, date and description. Initializes the appointment id,
	 * appointment date and description with the given id, date and description
	 * respectively.
	 * 
	 * @param id          the appointment id
	 * @param date        the appointment date
	 * @param description the appointment description
	 */
	public Appointment(String id, Date date, String description) {
		appointmentId = validateAndTruncateId(id);
		appointmentDate = validateDate(date);
		this.description = validateAndTruncateDescription(description);
	}

	/**
	 * Validates and truncates the appointment id.
	 * 
	 * @param id the appointment id
	 * @return the truncated appointment id
	 */
	public String validateAndTruncateId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("The appointment ID cannot be null.");
		}
		if (id.length() > APPOINTMENT_ID_LENGTH) {
			throw new IllegalArgumentException("Appointment ID cannot exceed " + APPOINTMENT_ID_LENGTH + " characters.");
		}
		this.appointmentId = id;
		return id;
	}

	/**
	 * Gets the appointment id.
	 * 
	 * @return the appointment id
	 */
	public String getAppointmentId() {
		return appointmentId;
	}

	/**
	 * Validates the appointment date.
	 * 
	 * @param date the appointment date
	 * @return the validated appointment date
	 */
	public Date validateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("The appointment date cannot be null.");
		}
		if (date.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment with a past date.");
		}
		this.appointmentDate = date;
		return date;
	}
	
	// Getter method to return the appointment date
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	// Validate and truncate the appointment description
	public String validateAndTruncateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("The appointment description cannot be null.");
		}
		if (description.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException( "Appointment description cannot exceed " + APPOINTMENT_DESCRIPTION_LENGTH + " characters.");
			
		}
		this.description = description;
		return description;
	}

	// Getter method to return the appointment description
	public String getDescription() {
		return description;
	}
}