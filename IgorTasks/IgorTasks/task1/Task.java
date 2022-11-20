package IgorTasks.task1;

import IgorTasks.task1.TestDoc.Randomizer;

import java.util.Date;

public class Task extends Document{
    private Date taskDate; // дата выдачи поручения
    private Date taskDL; // срок исполнения поручения
    private String executor; // ответственный исполнитель
    private boolean SignOfControl; // признак контрольности
    private String assignmentController; // контролер поручения

    public Task(int ID, String documentName, String documentText, int documentRegID,
                Date dateOfRegistration, Person authorOfDocument, Date taskDate,
                Date taskDL, String executor, boolean signOfControl, String assignmentController) {
        super(ID, documentName, documentText, documentRegID, dateOfRegistration, authorOfDocument);
        this.taskDate = taskDate;
        this.taskDL = taskDL;
        this.executor = executor;
        SignOfControl = signOfControl;
        this.assignmentController = assignmentController;
    }
    public static Task createTask(){
        return new Task(Randomizer.createID(), Randomizer.createRandomString(), Randomizer.createRandomString(),
                Randomizer.createID(), Randomizer.createDate(), Randomizer.createPerson(), Randomizer.createDate(),
                Randomizer.createDate(), Randomizer.createRandomString(), true, Randomizer.createRandomString());
    }
    @Override
    public String toString() {
        return "Task{" +
                "taskDate=" + taskDate +
                ", taskDL=" + taskDL +
                ", executor='" + executor + '\'' +
                ", SignOfControl=" + SignOfControl +
                ", assignmentController='" + assignmentController + '\'' +
                '}';
    }
}
