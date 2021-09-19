package zadania.zadanie34;

import java.util.Date;
import java.util.Objects;

public class StackElement {

    private String name;

    private Date createDate;

    public StackElement(String name) {
        this.name = name;
        this.createDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackElement that = (StackElement) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "StackElement{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getName() {
        return name;
    }
}
