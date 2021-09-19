package zadania.zadanie36;

import java.util.Date;
import java.util.Objects;

public class QueueItem {

    private QueueItem next;
    private String name;
    private Date createDate;

    public QueueItem(String name) {
        this.name = name;
        createDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueItem queueItem = (QueueItem) o;
        return Objects.equals(name, queueItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public QueueItem getNext() {
        return next;
    }

    public void setNext(QueueItem next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }
}
