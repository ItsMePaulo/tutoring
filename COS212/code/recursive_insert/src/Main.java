import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[10];

        Random r = new Random(6);

        for (int i = 0; i < 10; i++) {
            array[i] = r.nextInt(100);
        }

        System.out.println("Unsorted Array");
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        int[] sortedArray = insert(array, 0);

        System.out.println("Sorted Array");
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }


    public static int[] insert(int[] unsortedArray, int index) {

        int[] sortedArray;

        // base case, return the sorted array with the last element
        if (index == unsortedArray.length - 1) {
            sortedArray = new int[unsortedArray.length];
            sortedArray[index] = unsortedArray[index];
            return sortedArray;
        }

        int[] partiallySortedArray = insert(unsortedArray, index + 1); // holds the sorted list from the last iteration
        sortedArray = new int[unsortedArray.length]; // empty list

        int newValue = unsortedArray[index]; // the new value we want to add in at this recursive call
        int lastIndex = partiallySortedArray.length - 1;
        boolean added = false;


        // loop through partially sorted array which starts at one index higher than current index
        for (int i = index + 1; i <= lastIndex; ) {

            if (!added && newValue < partiallySortedArray[i]) {
                sortedArray[index++] = newValue;
                added = true;
            } else {
                sortedArray[index++] = partiallySortedArray[i++];
            }
        }

        if (!added) {
            sortedArray[lastIndex] = newValue;
        }

        return sortedArray;
    }
}
