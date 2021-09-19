package zadania.zadanie34;

public class StackProgram {

    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(new StackElement("Elemenet 1"));
        stack.push(new StackElement("Elemenet 1"));
        stack.push(new StackElement("Elemenet 3"));
        stack.push(new StackElement("Elemenet 4"));

        System.out.println();
        System.out.println(stack.count());

        System.out.println(stack.peek());
        System.out.println(stack.count());
        System.out.println(stack.count());
        System.out.println(stack.pop());

        System.out.println(stack.count());
        System.out.println(stack.pop());

        System.out.println(stack.count());
        System.out.println(stack.pop());

        System.out.println(stack.count());
        System.out.println(stack.pop());
    }
}
