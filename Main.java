import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        int size = 10;
        int[] randomArray = RandomizedArray(size, 100, 0);
        int[] bubbleClone = CloneArray(randomArray);
        long bstartTime = System.currentTimeMillis();
        BubbleSort(bubbleClone);
        long bendTime = System.currentTimeMillis();
        long bduration = bendTime - bstartTime;
        System.out.println("Sorting a random array with size " + size + " took bubble sort " + bduration + "ms to complete");
        int[] selectionClone = CloneArray(randomArray);
        long sstartTime = System.currentTimeMillis();
        SelectionSort(selectionClone);
        long sendTime = System.currentTimeMillis();
        long sduration = sendTime - sstartTime;
        System.out.println("Sorting a random array with size " + size + " took selection sort " + sduration + "ms to complete");
        int[] insertionClone = CloneArray(randomArray);
        long istartTime = System.currentTimeMillis();
        InsertionSort(insertionClone);
        long iendTime = System.currentTimeMillis();
        long iduration = iendTime - istartTime;
        System.out.println("Sorting a random array with size " + size + " took selection sort " + iduration + "ms to complete");

    }

    public static int[] RandomizedArray(int size, int max, int min) {
        if (max-min + 1 >= size) {
            int[] sourceArray = new int[max - min+1];
            for(int i = 0; i < (max-min + 1); i++) {
                sourceArray[i] = min + i;
            }
            shuffle(sourceArray);
            int[] result = new int[size];
            for(int i = 0; i < size; i++) {
                result[i] = sourceArray[i];
            }
            return result;
        } else {
            return null;
        }
    }

    public static void shuffle(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            Random r = new Random();
            int pos1 = r.nextInt(array.length - 1);
            int pos2 = r.nextInt(array.length - 1);
            int temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;
        }
    }

    public static int[] BubbleSort(int[] arr) {
        int temp;
        for(int j = 0; j < arr.length; j++) {
            for(int i = 0; i < arr.length-j-1; i++) {
                if(arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println("BubbleSort array:");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length-1) {
                System.out.println(arr[i]);
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
        return arr;
    }

    public static int[] SelectionSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length-1; ++i) {
            int smallest = i;
            for(int j = i+1; j < arr.length; ++j) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }

        System.out.println("SelectionSort array:");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length-1) {
                System.out.println(arr[i]);
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
        return arr;
    }

    public static int[] CloneArray(int[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] InsertionSort(int[] arr) {
        int i = 0;
        int j = 0;
        int temp = 0;
        for(i = 1; i < arr.length; i++) {
            j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        
        System.out.println("InsertionSort array:");
        for(int k = 0; k < arr.length; k++) {
            if(k == arr.length-1) {
                System.out.println(arr[k]);
            }
            else {
                System.out.print(arr[k] + ", ");
            }
        }
        return arr;
    }
}
 
