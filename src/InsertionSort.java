import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.Duration;
import java.time.Instant;

public class Sort {

    // This method should sort the input list using the algorithm for insertion sort.
    // That is, first create a new ArrayList with all of the elements from input ns.
    // Then, iterate through this new ArrayList - comparing a current element to its
    // predecessor. While current is less, it is swapped w predecessor.

    // For those who prefer wordier instructions, check out the Lab 7 post on canvas 🙂
    // Otherwise, best of luck on the lab! Tests/debugging will help a lot with IndexOutOfBoundsExceptions
    static List<Integer> insertionSort (List<Integer> ns) {
        // TODO
        List<Integer> myList = ns ;

        for(int i = 1 ; i < myList.size() ;i++){
            int current = i ;
            int pred = current - 1 ;
            while(myList.get(current) < myList.get(pred)){
                //System.out.println("hello") ;
                int temp = myList.get(pred) ;
                myList.set(pred,myList.get(current)) ;
                myList.set(current,temp) ;
                current-- ;
                if(pred != 0){
                    pred-- ;
                }
            }
        }
        return myList;
    }

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(6,5,3,1,8,7,2,4);

        System.out.printf("Original list ns = %s%n", list1);
        System.out.printf("insertionSort ns = %s%n%n", insertionSort(list1));

        // TODO: A few more correctness tests
        List<Integer> list10 = Arrays.asList(61,51,31,11,81,71,21,41);

        System.out.printf("Original list ns = %s%n", list10);
        System.out.printf("insertionSort ns = %s%n%n", insertionSort(list10));
        // TODO: Think about what inputs would result in insertion sort taking O(n^2) vs what would cause it 
        // to run in O(n). Create a few test cases to demonstrate these differences in running time.

        // TODO: Also test how long it takes to run these insertion sorts, example given below.

        Instant start = Instant.now();
        List<Integer> list2 = Arrays.asList(8,7,6,5,1,2,3,4);
        System.out.printf("Original list ns = %s%n", list2);
        System.out.printf("insertionSort ns = %s%n", insertionSort(list2));
        Instant end = Instant.now();
        Duration time = Duration.between(start, end);
        System.out.println(time.toNanos()); // insertion sort is to fast with small input. We will see results with toNanos()

        System.out.println("Worst Case") ;
        Instant start1 = Instant.now();
        List<Integer> list20 = Arrays.asList(8,7,6,5,4,3,2,1);
        System.out.printf("Original list ns = %s%n", list20);
        System.out.printf("insertionSort ns = %s%n", insertionSort(list20));
        Instant end1 = Instant.now();
        Duration time1 = Duration.between(start1, end1);
        System.out.println(time1.toNanos()); // insertion sort is to fast with small input. We will see results with toNanos()

        System.out.println("Best Case") ;
        Instant start3 = Instant.now();
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.printf("Original list ns = %s%n", list3);
        System.out.printf("insertionSort ns = %s%n", insertionSort(list3));
        Instant end3 = Instant.now();
        Duration time3 = Duration.between(start3, end3);
        System.out.println(time3.toNanos()); // insertion sort is to fast with small input. We will see results with toNanos()

    }
}