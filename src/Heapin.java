import java.util.ArrayList;

public class Heapin {

    private ArrayList<Integer> minheap;
    private int size;

    public Heapin() {
        minheap = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is Empty");
        } return minheap.get(0);
    }

    public void add(int value) {
        minheap.add(value);
        size += 1;

        int currIndex = minheap.size() -1;
        int parentIndex = (currIndex - 1) /2;

        while (currIndex > 0 && minheap.get(currIndex) < minheap.get(parentIndex)) {

            int hold = minheap.get(currIndex);
            minheap.set(currIndex, minheap.get(parentIndex));
            minheap.set(parentIndex, hold);

            currIndex = parentIndex;
            parentIndex = (currIndex -1) /2;
        }

    }

    public void poll() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is Empty");
        }

        //
    }



    public static void main(String[] args) {
        Heapin hi = new Heapin();
        hi.add(1);
        hi.add(1);
        hi.add(1);
        hi.add(1);

        System.out.println(hi.getSize());
        System.out.println(hi.isEmpty());

    }

}
