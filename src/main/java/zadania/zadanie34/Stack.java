package zadania.zadanie34;

public class Stack {

    private StackElement[] stackElements;
    private int currentSize;

    public Stack(int size) {
        stackElements = new StackElement[size];
        currentSize = 0;
    }

    public StackElement push(StackElement stackElement) {

        if (checkStackElementExistance(stackElement)) {
            System.out.printf("Element %s znajduje się już na stosie\n", stackElement.getName());
            return null;
        }

        if (currentSize >= stackElements.length) {
            System.out.println("Przekroczono rozmiar stosu");
            return null;
        }

        stackElements[currentSize] = stackElement;
        currentSize++;

        return stackElement;
    }

    public StackElement pop() {

        if (currentSize == 0) {
            System.out.println("Stos jest pusty");
            return null;
        }

        StackElement result = stackElements[--currentSize];

        return result;
    }

    public StackElement peek() {

        if (currentSize == 0) {
            System.out.println("Stos jest pusty");
            return null;
        }

        return stackElements[currentSize - 1];
    }

    public int count() {
        return currentSize;
    }

    private boolean checkStackElementExistance(StackElement stackElement) {

        for (int i = 0; i < currentSize; i ++) {
            if (stackElements[i] == null) {
                continue;
            }

            if (stackElements[i].equals(stackElement)) {
                return true;
            }
        }

        return false;
    }
}
