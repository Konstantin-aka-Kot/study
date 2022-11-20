package IgorTasks.task1;

import java.util.Date;

public abstract class Document implements Comparable<Document>, Storable {

    private int ID; // идентификатор документа
    private String documentName; // название документа
    private String documentText; // текст документа
    private int documentRegID; // регистрационный номер документа
    private Date dateOfRegistration; // дата регистрации документа
private Person authorOfDocument; // автор документа

    public Document(int ID, String documentName, String documentText, int documentRegID, Date dateOfRegistration, Person authorOfDocument) {
        this.ID = ID;
        this.documentName = documentName;
        this.documentText = documentText;
        this.documentRegID = documentRegID;
        this.dateOfRegistration = dateOfRegistration;
        this.authorOfDocument = authorOfDocument;
    }

    public int getDocumentRegID() {
        return documentRegID;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }
public int getID(){
        return this.ID;
}
public String getTable(){
        return null;
}
    @Override
    public int compareTo(Document o) {
        if (this.documentRegID > o.getDocumentRegID()){
            return 1;
        } else if (this.documentRegID < o.getDocumentRegID()) {
            return -1;
        } else if (this.getDateOfRegistration().before(o.getDateOfRegistration())){
            return  1;
        } else if (this.getDateOfRegistration().after(o.getDateOfRegistration())) {
            return  -1;
        } else {
            return 0;
        }
    }


}
