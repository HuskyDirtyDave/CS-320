package Project1.Main;

public class Contact {

    private static final int PHONE_NUMBER_LENGTH = 10;
    private static final byte ID_LENGTH = 10;
    private static final byte FIRST_NAME_LENGTH = 10;
    private static final byte LAST_NAME_LENGTH = 10;
    private static final byte ADDRESS_LENGTH = 30;
    private static final String INITIALIZER = "INITIAL";
    private static final String INITIALIZER_NUM = "1235559999";

    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Default constructor
    public Contact() {
        this.contactId = INITIALIZER;
        this.firstName = INITIALIZER;
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // Constructor with contact ID
    public Contact(String contactId) {
        updateContactId(contactId);
        this.firstName = INITIALIZER;
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // Constructor with contact ID and first name
    public Contact(String contactId, String firstName) {
        updateContactId(contactId);
        updateFirstName(firstName);
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // Constructor with contact ID, first name, and last name
    public Contact(String contactId, String firstName, String lastName) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    // Constructor with contact ID, first name, last name, and phone number
    public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        updatePhoneNumber(phoneNumber);
        this.address = INITIALIZER;
    }

    // Constructor with all parameters
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        updatePhoneNumber(phoneNumber);
        updateAddress(address);
    }

    public final String getContactId() {
        return contactId;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public final String getAddress() {
        return address;
    }

    public void updateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        } else if (firstName.length() > FIRST_NAME_LENGTH) {
            throw new IllegalArgumentException("First name cannot be longer than " + FIRST_NAME_LENGTH + " characters.");
        } else {
            this.firstName = firstName;
        }
    }

    public void updateLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        } else if (lastName.length() > LAST_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name cannot be longer than " + LAST_NAME_LENGTH + " characters.");
        } else {
            this.lastName = lastName;
        }
    }

    public void updatePhoneNumber(String phoneNumber) {
        String regex = "[0-9]+";
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        } else if (phoneNumber.length() != PHONE_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Phone number length invalid. Ensure it is " + PHONE_NUMBER_LENGTH + " digits.");
        } else if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("Phone number cannot have anything but numbers");
        }
        this.phoneNumber = phoneNumber;
    }

    public void updateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty");
        } else if (address.length() > ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address cannot be longer than " + ADDRESS_LENGTH + " characters");
        }
        this.address = address;
    }

	  public void updateContactId(String contactId) {
	    if (contactId == null) {
	      throw new IllegalArgumentException("Contact ID cannot be empty");
	    } else if (contactId.length() > ID_LENGTH) {
	      throw new IllegalArgumentException("Contact ID cannot be longer than " +
	    		  ID_LENGTH + " characters");
	    } else {
	      this.contactId = contactId;
	    }
	  }
	}