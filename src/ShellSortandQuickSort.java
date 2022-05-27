import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math ;
public class SortDist {
    static int increment(int n) {
        // From https://oeis.org/search?q=shell+sort
        // a(n) = 9*2^n - 9*2^(n/2) + 1 if n is even;
        // a(n) = 8*2^n - 6*2^((n+1)/2) + 1 if n is odd.
        if (n % 2 == 0)
            return (int) (9 * Math.pow(2, n) - 9 * Math.pow(2, n / 2) + 1);
        else
            return (int) (8 * Math.pow(2,n) - 6 * Math.pow(2,(n + 1) / 2) + 1);
    }
    /**
     * Steps:
     * 1. create an array list gapSequence that calls increment above until the
     *    gap is more than half of the size of the array (increase i by 1 each time you call increment)
     * 2. Start from the largest gap and iterate down the list of gaps
     * 3. For each gap, do an insertion sort for the elements separated
     *    by the given gap
     * 4. Return your list of sorted elements at the end of all gaps
     */
    static List<Integer> shellSort (List<Integer> ns) {
        ArrayList<Integer> gapSequence = new ArrayList<>();
        List<Integer> result = ns;
        int i = 1;
        gapSequence.add(0,increment(0)) ;
        while(gapSequence.get(0) < ns.size()/2 ){
            gapSequence.add(0,increment(i)) ;
            i++ ;
        }
        //gapSequence.add(increment(i)) ;

        for(int x = 0 ; x < gapSequence.size() ; x++){//go through each gap
            int gapSize = gapSequence.get(x) ;
            for(int y = 0 ; y < gapSize ; y++){ //get initial index of each sublist
                for(int z = y + gapSize ; z <= ns.size() ; z+= gapSize){//go through each sublist and perform insertion sort
                    for(int a = z - gapSize ; (a > gapSize) && (ns.get(a) < ns.get(a-gapSize)) ; a -= gapSize){ //perform insertion sort
                        int temp = ns.get(a) ;
                        int lowerInd = a - gapSize ;
                        ns.set(a,ns.get(lowerInd)) ;
                        ns.set(lowerInd,temp) ;
                    }
                }
            }
        }
        return result;
    }

    static int partition(List<Integer> ns, int begin, int end)
    {
        //TODO: Task C Helper Function
        int pivInd = (begin + end) /2 ;
        int temp = ns.get(end) ;
        ns.set(end,ns.get(pivInd)) ;
        ns.set(pivInd,temp) ;
        int pivot = ns.get(end) ;
        int origEnd = end ;
        end = end - 1 ;
        //System.out.println(pivot) ;

        while(end > begin)
        {
            while(ns.get(begin) < pivot)
            {
                begin++ ;
                //System.out.println("aye") ;
                //break ;
            }
            while(ns.get(end) >= pivot && end > begin)
            {
                end-- ;
                //System.out.println("Whoa") ;
            }
            if(end > begin && ns.get(begin) != ns.get(end))
            {
                int temp1 = ns.get(begin) ;
                ns.set(begin,ns.get(end)) ;
                ns.set(end,temp1) ;
                //System.out.println("Hello") ;
            }
           //System.out.println("here") ;
        }
        int temp2 = ns.get(origEnd) ; //put the pivot, which was put at the end earlier, in a holding var
        ns.set(origEnd,ns.get(begin)) ; //set the last element to what is at the cross section
        ns.set(begin,temp2) ; //put the pivot where it belongs
        return begin ;
    }

    static List<Integer> quickSort(List<Integer> ns, int begin, int end)
    {
        //TODO: Implement Task C
        int partInd = partition(ns,begin,end) ;
        if(partInd - begin > 1)
        {
            quickSort(ns, begin, partInd - 1) ;
        }
        if(end - partInd > 1){
            quickSort(ns,partInd + 1, end) ;
        }

        return ns;
    }

    public static void main(String args[]){
        List<Integer> list1 = Arrays.asList(1,9,81,32,4,94,7,2);
        List<Integer> list2 = Arrays.asList(1,23,343,423,533,24,73,83,9,10) ;
        List<Integer> list3 = Arrays.asList(1,2,34,2,303,234,3,3,6,70,43,254,63,7,8,5,4,56,78,9,8,6,5) ;
        List<Integer> list4 = Arrays.asList(22,323,223,2334,4546,6278,554,34) ;
        List<Integer> list5 = Arrays.asList(1,2,3) ;


        /*
        int currInd = 7 ;
        for(int i = 0 ; i < 100 ; i++){
            list1.ad
            list1.add(currInd,(int)(Math.random() * 100)) ;
            currInd++ ;
        }
        */

        Instant start = Instant.now();
        System.out.println("Shellsort results") ;
        System.out.println(shellSort(list1));
        System.out.println(shellSort(list2)) ;
        System.out.println(shellSort(list3)) ;
        System.out.println(shellSort(list4)) ;

        Instant end = Instant.now();
        //System.out.println(Duration.between(start, end).toNanos());

        //start = Instant.now();
        System.out.println("Quicksort results") ;
        quickSort(list1,0,7);
        System.out.println(list1);

        quickSort(list2,0,9);
        System.out.println(list2);

        quickSort(list3,0,list3.size() - 1);
        System.out.println(list3);

        quickSort(list4,0,list4.size() - 1);
        System.out.println(list4);
        //end = Instant.now();
        //System.out.println(Duration.between(start,end).toNanos());
    }
}