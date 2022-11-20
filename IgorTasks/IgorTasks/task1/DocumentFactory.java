package IgorTasks.task1;
/*
Фабрика создает новые входящие, исходящие документы + задачи.
При добавлении нового функционала, нужно предварительно добавить в DocumentType
 */
public class DocumentFactory {
    public void createDocument (DocumentType type) {
        switch (type) {
            case INCOMING:
                Incoming.createIncoming();
                break;
            case OUTGOING:
                Outgoing.createOutgoing();
                break;
            case TASK:
                Task.createTask();
                break;
        }
    }
}
