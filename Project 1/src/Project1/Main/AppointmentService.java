package Project1.Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	  // Use an ArrayList instead of a raw List, for type safety
	  private final List<Appointment> appointmentList = new ArrayList<>();

	  private String newUniqueId() {
	    // Use a constant for the length of the substring to make the code more readable
	    final int substringLength = 10;

	    return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), substringLength));
	  }

	  public void newAppointment() {
	    Appointment appt = new Appointment(newUniqueId());
	    appointmentList.add(appt);
	  }

	  public void newAppointment(Date date) {
	    Appointment appt = new Appointment(newUniqueId(), date);
	    appointmentList.add(appt);
	  }

	  public void newAppointment(Date date, String description) {
	    Appointment appt = new Appointment(newUniqueId(), date, description);
	    appointmentList.add(appt);
	  }

	  public void deleteAppointment(String id) throws Exception {
	    // Use a separate method to search for the appointment, to keep this method's logic clean
	    appointmentList.remove(searchForAppointment(id));
	  }

	  public List<Appointment> getAppointmentList() { return appointmentList; }

	  private Appointment searchForAppointment(String id) throws Exception {
	    int index = 0;
	    while (index < appointmentList.size()) {
	      if (id.equals(appointmentList.get(index).getAppointmentId())) {
	        return appointmentList.get(index);
	      }
	      index++;
	    }

	    // Use a custom Exception type to make it easier to catch specific exceptions in client code
	    throw new AppointmentNotFoundException("We are unable to find that appointment it looks like it does not exist!");
	  }

	  public static class AppointmentNotFoundException extends Exception {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AppointmentNotFoundException(String message) {
	      super(message);
	    }
	  }
	}
