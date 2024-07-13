import java.util.ArrayList;

public class Heapin {

    private ArrayList<Integer> minheap;
    private int size;

    public Heapin() {
        minheap = new ArrayList<>();
        size = 0;
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
        size ++;

        int currIndex = size -1;
        int parentIndex = (currIndex - 1) /2;

        while (currIndex > 0 && minheap.get(currIndex) < minheap.get(parentIndex)) {

            int hold = minheap.get(currIndex);
            minheap.set(currIndex, minheap.get(parentIndex));
            minheap.set(parentIndex, hold);

            currIndex = parentIndex;
            parentIndex = (currIndex -1) /2;
        }

    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is Empty");

        }


        // hold onto root
        int tempRoot = minheap.get(0);
        // get last element
        int lastAdded = minheap.remove(size-1);
        size --;

        if (!(isEmpty()) ) {
            minheap.set(0, lastAdded);
            // bring down
            int currIndex = 0;
            int leftIndex = (2* currIndex +1);
            int rightIndex = (2 * currIndex +2);

            while ( leftIndex < minheap.size() ) {
                int smallestChild = leftIndex;

                if ( rightIndex < minheap.size() && minheap.get(rightIndex) < minheap.get(leftIndex) ) {
                    smallestChild = rightIndex; }

                if ( minheap.get(currIndex) <= minheap.get(smallestChild) ) {
                    break; }

                int temp = minheap.get(currIndex);
                minheap.set(currIndex, minheap.get(smallestChild));
                minheap.set(smallestChild, temp);

                currIndex = smallestChild;
                leftIndex = (2 * currIndex + 1);
                rightIndex = (2 * currIndex +2);
            }

        }
        return tempRoot;
    }



    public static void main(String[] args) {
        Heapin hi = new Heapin();
        hi.add(1);
        hi.add(2);
        hi.add(3);
        hi.add(4 );
        hi.poll();
        hi.poll();
        hi.poll();
        hi.poll();
        System.out.println(hi.getSize());

        hi.poll();


        System.out.println(hi.isEmpty());

    }

}
