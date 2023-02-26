package Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project1.Main.Contact;

class ContactTest {
    private static final String INITIALIZER = "INITIAL";
    private static final String INITIALIZER_NUM = "1235559999";
    private static final byte CONTACT_ID_LENGTH = 10;
    private static final byte CONTACT_NAME_LENGTH = 10;
    private static final byte CONTACT_ADDRESS_LENGTH = 30;
    private static final int CONTACT_PHONENUM_LENGTH = 10;

    private String contactId;
    private String firstNameTest;
    private String lastNameTest;
    private String phoneNumberTest;
    private String addressTest;
    private String tooLongContactId;
    private String tooLongFirstName;
    private String tooLongLastName;
    private String tooLongPhoneNumber;
    private String tooShortPhoneNumber;
    private String tooLongAddress;

    @BeforeEach
    void setUp() {
        contactId = "1029F847A6";
        firstNameTest = "John";
        lastNameTest = "Smith";
        phoneNumberTest = "5553331234";
        addressTest = "1 Audrey Jersey City NJ 07305";
        tooLongContactId = "112233445566778899";
        tooLongFirstName = "John Jacob Jingle";
        tooLongLastName = "-heimer Schmidt";
        tooLongPhoneNumber = "55512341234";
        tooShortPhoneNumber = "1234567";
        tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
    }

    @Test
    void contactTest() {
        Contact contact = new Contact();
        assertAll("constructor",
                () -> assertNotNull(contact.getContactId()),
                () -> assertNotNull(contact.getFirstName()),
                () -> assertNotNull(contact.getLastName()),
                () -> assertNotNull(contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress())
        );
    }

    @Test
    void contactIdConstructorTest() {
        Contact contact = new Contact(contactId);
        assertAll("constructor one",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(INITIALIZER, contact.getFirstName()),
                () -> assertEquals(INITIALIZER, contact.getLastName()),
                () -> assertEquals(INITIALIZER_NUM, contact.getPhoneNumber()),
                () -> assertEquals(INITIALIZER, contact.getAddress())
        );
    }

    @Test
    void contactIdAndFirstNameConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest);
        assertAll("constructor two",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(INITIALIZER, contact.getLastName()),
                () -> assertEquals(INITIALIZER_NUM, contact.getPhoneNumber()),
                () -> assertEquals(INITIALIZER, contact.getAddress())
        );
    }

    @Test
    void contactIdAndFullNameConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
        assertAll("constructor three",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertEquals(INITIALIZER_NUM, contact.getPhoneNumber()),
                () -> assertEquals(INITIALIZER, contact.getAddress())
        );
    }
    @Test
    void contactIdFullNamePhoneNumberConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        assertAll("constructor four",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertNotNull(contact.getAddress()));
    }
    @Test
    void allTheProperThingsConstructorTest() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                phoneNumberTest, addressTest);
        assertAll("constructor all",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertEquals(addressTest, contact.getAddress()));
    }

    @Test
    void updateFirstNameTest() {
        Contact contact = new Contact();
        contact.updateFirstName(firstNameTest);
        assertAll("first name",
                () -> assertEquals(firstNameTest, contact.getFirstName()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null), "First name cannot be empty"),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(tooLongFirstName), "First name cannot be longer than 10 characters"));
    }

    @Test
    void updateLastNameTest() {
        Contact contact = new Contact();
        contact.updateLastName(lastNameTest);
        assertAll("last name",
                () -> assertEquals(lastNameTest, contact.getLastName()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null), "Last name cannot be empty"),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(tooLongLastName), "Last name cannot be longer than 10 characters"));
    }

    @Test
    void updatePhoneNumberTest() {
        Contact contact = new Contact();
        contact.updatePhoneNumber(phoneNumberTest);
        assertAll("phone number",
                () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null), "Phone number cannot be empty."),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooLongPhoneNumber), "Phone number length invalid. Ensure it is 10 digits."),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooShortPhoneNumber), "Phone number length invalid. Ensure it is 10 digits."),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(contactId), "Phone number cannot have anything but numbers"));
    }

    @Test
    void updateAddressTest() {
        Contact contact = new Contact();
        contact.updateAddress(addressTest);
        assertAll("address",
                () -> assertEquals(addressTest, contact.getAddress()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null), "Address cannot be empty"),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(tooLongAddress), "Address cannot be longer than 30 characters"));
    }

    @Test
    void updateContactIdTest() {
        Contact contact = new Contact();
        contact.updateContactId(contactId);
        assertAll("contact ID",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null), "Contact ID cannot be empty"),
                () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(tooLongContactId), "Contact ID cannot be longer than 10 characters"));
    }
    }
