package zadania.zadanie36;

public class QueueProgram {

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.add(new QueueItem("Elemenet 1"));
        queue.add(new QueueItem("Elemenet 2"));
        queue.add(new QueueItem("Elemenet 3"));
        queue.add(new QueueItem("Elemenet 3"));

        queue.add(new QueueItem("Nowy head"), 0);
        queue.add(new QueueItem("Nowy index 2"), 2);

        System.out.println(queue.count());

        queue.poll();

        System.out.println(queue.count());
    }
}
