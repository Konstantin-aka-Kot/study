package IgorTasks.task1;

import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private String post;
    private Date dateOfBirth;
    private String phoneNumber;

    public Person(String name, String surname, String patronymic, String post, Date dateOfBirth, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.post = post;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }
}
