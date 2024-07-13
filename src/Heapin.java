import java.util.ArrayList;

public class Heapin {

    private ArrayList<Integer> minheap;
    private int size;

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return (2 * i) + 1; }
    private int rightChild(int i) { return (2 * i) + 2; }

    public Heapin() {
        minheap = new ArrayList<>();
        size = 0;
    }

    public int size() {
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

    private void swap(int i, int j) {
        int temp = minheap.get(i);
        minheap.set(i, minheap.get(j));
        minheap.set(j, temp);
    }

    public void remove(int value) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is Empty");
        }
        // find index of value
        int valueIndex = -1;
        for (int i = 0; i < size; i++) {
            if (minheap.get(i) == value) {
                valueIndex = i;
                break;
            }
        }

        if (valueIndex == -1) {
            throw new IllegalArgumentException("Element not found in heap");
        }

        minheap.set(valueIndex, minheap.size()-1);
        size--;

        // replace the element with last element in the heap
        int currentIndex = valueIndex;
        while (true) {
            int left = leftChild(currentIndex);
            int right = rightChild(currentIndex);
            int smallest = currentIndex;

            if (left < size && minheap.get(left) < minheap.get(smallest)) {
                smallest = left;
            }
            if (right < size && minheap.get(right) < minheap.get(smallest)) {
                smallest = right;
            }
            if (smallest != currentIndex) {
                swap(currentIndex, smallest);
                currentIndex = smallest;
            } else {
                break;
            }
        }

        // if the element needs to move up
        while (currentIndex != 0 && minheap.get(parent(currentIndex)) > minheap.get(currentIndex)) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
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

        System.out.println(hi.isEmpty());
        hi.remove(1);
//        hi.poll();
//        hi.poll();
//        hi.poll();
//        hi.poll();
        System.out.println(hi.size());
//
//        System.out.println(hi.poll());
//
//
//        System.out.println(hi.isEmpty());

    }

}
