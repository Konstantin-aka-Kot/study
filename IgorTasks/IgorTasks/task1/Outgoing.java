package IgorTasks.task1;

import IgorTasks.task1.TestDoc.Randomizer;

import java.util.Date;

public class Outgoing extends Document{
    private String addresseeOutgoing; // адресат
    private String deliveryMethod; // способ доставки

    public Outgoing(int ID, String documentName, String documentText, int documentRegID, Date dateOfRegistration, Person authorOfDocument, String addresseeOutgoing, String deliveryMethod) {
        super(ID, documentName, documentText, documentRegID, dateOfRegistration, authorOfDocument);
        this.addresseeOutgoing = addresseeOutgoing;
        this.deliveryMethod = deliveryMethod;
    }
    public static Outgoing createOutgoing(){
        return new Outgoing(Randomizer.createID(), Randomizer.createRandomString(),
                Randomizer.createRandomString(), Randomizer.createID(), Randomizer.createDate(),
                Randomizer.createPerson(), Randomizer.createRandomString(), Randomizer.createRandomString());
    }
    @Override
    public String toString() {
        return "Outgoing{" +
                "addresseeOutgoing='" + addresseeOutgoing + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }
}
