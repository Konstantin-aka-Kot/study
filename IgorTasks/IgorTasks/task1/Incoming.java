package IgorTasks.task1;

import IgorTasks.task1.TestDoc.Randomizer;

import java.util.Date;

public class Incoming extends Document{
    private String sender; // отправитель
    private String addresseeIncoming; // адресат
    private int outgoingNumber; // исходящий номер
    private Date outgoingRegistrationDate; // исходящая дата регистрации

    @Override
    public String toString() {
        return "Incoming{" +
                "sender='" + sender + '\'' +
                ", addresseeIncoming='" + addresseeIncoming + '\'' +
                ", outgoingNumber=" + outgoingNumber +
                ", outgoingRegistrationDate=" + outgoingRegistrationDate +
                '}';
    }

    public Incoming(int ID, String documentName, String documentText, int documentRegID, Date dateOfRegistration, Person authorOfDocument, String sender, String addresseeIncoming, int outgoingNumber, Date outgoingRegistrationDate) {
        super(ID, documentName, documentText, documentRegID, dateOfRegistration, authorOfDocument);
        this.sender = sender;
        this.addresseeIncoming = addresseeIncoming;
        this.outgoingNumber = outgoingNumber;
        this.outgoingRegistrationDate = outgoingRegistrationDate;
    }

    public static Incoming createIncoming(){
        return new Incoming(Randomizer.createID(), Randomizer.createRandomString(),
                Randomizer.createRandomString(),Randomizer.createID(), Randomizer.createDate(),
                Randomizer.createPerson(), Randomizer.createRandomString(),
                Randomizer.createRandomString(), Randomizer.createID(), Randomizer.createDate());
    }
}
