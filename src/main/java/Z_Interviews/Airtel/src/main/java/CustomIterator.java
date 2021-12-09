package Z_Interviews.Airtel.src.main.java;

public class CustomIterator {
    private int[] arr;
    private int index;

    CustomIterator(int[] arr) {
        arr = arr;
        index = -1;
    }

    int next() throws NoNextElementFoundException {
        if (!hasNext()) {
            throw new NoNextElementFoundException();
        }

        index++;
        return arr[index];
    }

    boolean hasNext() {
        return index < arr.length - 1;
    }

}
