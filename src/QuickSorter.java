import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class QuickSorter 
{
	int[] arr ; 
	int arrSize  ; 
	
	public QuickSorter(int arrSize)
	{
		this.arrSize = arrSize ; 
		arr = new int[arrSize] ; 
		for(int i = 0 ; i < arrSize ; i++)
		{
			arr[i] = (int)(Math.random() * 50) + 1 ; 
		}
	}
	
	public QuickSorter(int[] a)
	{
		this.arr = a ; 
		this.arrSize = a.length ; 
	}
	public void printArray() 
	
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			if( i == arr.length -1)
			{
				System.out.print(arr[i]) ; 
			}
			else
			{
				System.out.print(arr[i] + " ") ; 
			}
		}
	}
	
	public int findRegMedian() 
	{
		return findRegMed(arr) ; 
	}
	
	public static int findRegMed(int[] array)
	{
		int median = 0 ; 
		if(array.length == 1 || array.length == 2)
		{
			return array[0] ; 
		}
		else if(array.length == 0 )
		{
			return -1 ; 
		}
		else if(array.length % 2 == 1)
		{
			return array[array.length / 2] ; 
		}
		else
		{
			return array[array.length/2 - 1] ; 
		}
		
	}
	
	public static int findPMed(int[] array)
	{
		int[]a = new int[3] ; 
		int[]b = new int[3] ; 
		int[]c = new int[3] ; 
		for(int i = 0 ; i < 9 ; i++)
		{
			if(i < 3)
			{
				a[i] = array[i * ((array.length - 1) / 8)] ; 
			}
			else if(i < 6)
			{
				b[i] = array[i * ((array.length - 1) / 8)] ; 
			}
			else if(i < 9)
			{
				c[i] = array[i * ((array.length - 1) / 8)] ;
			}
		}
		int[] d = {findRegMed(a), findRegMed(b), findRegMed(c)} ; 
		return findRegMed(d) ; 
		
	}
	
	public static int findOtherMed(int[] array)
	{
		int x = array.length / 3 ; 
		int secX = x * 2 ; 
		
		int[] a = new int[x] ; 
		System.out.println() ; 
		for(int i = 0 ; i < x ; i++)
		{
			a[i] = array[i] ; 
			System.out.print(a[i] + " " ) ; 
		}
		Arrays.sort(a);
		
		int[] b = new int[x] ;
		System.out.println() ; 
		System.out.println() ; 
		int bIndex = 0 ; 
		for(int i = x ; i < secX ; i++)
		{
			b[bIndex] = array[i] ; 
			
			System.out.print(b[bIndex]+ " " ) ; 
			bIndex++ ; 
		}
		Arrays.sort(b);
		
		int[] c = new int[array.length - secX] ; 
		System.out.println() ; 
		System.out.println() ;
		int cIndex = 0 ; 
		for(int i = secX ; i < array.length ; i++)
		{
			c[cIndex] = array[i] ; 
			System.out.print(c[cIndex]+ " " ) ; 
			cIndex++ ; 
		}
		Arrays.sort(c);
		
		int[] d = {findRegMed(a), findRegMed(b), findRegMed(c)} ;
		Arrays.sort(d); 
		System.out.println(); 
		return findRegMed(d) ; 
	}
	
     /**
	 Sorts an array, using quick sort.
	 @param a the array to sort
	 */
	 public static void sort(int[] a)
	 {  
	    sort(a, 0, a.length - 1);
	 }
	
	 /**
	    Sorts a portion of an array, using quick sort.
	    @param a the array to sort
	    @param from the first index of the portion to be sorted
	    @param to the last index of the portion to be sorted
	 */
	 public static void sort(int[] a, int from, int to)
	 {
	    if (from >= to) { return; }
	    int p = partition(a, from, to);
	    sort(a, from, p);
	    sort(a, p + 1, to);
	 }
	
	 /**
	    Partitions a portion of an array.
	    @param a the array to partition
	    @param from the first index of the portion to be partitioned
	    @param to the last index of the portion to be partitioned
	    @return the last index of the first partition
	 */
	 public static int partition(int[] a, int from, int to)
	 {
		 int pivot = 0 ; 
		 if(a.length <= 7)
		 {
			 pivot = findRegMed(a)  ; 
		 }
		 else if(a.length <= 40)
		 {
			 int[] z = {a[0] , a[a.length/2] , a[a.length -1]} ;
			 pivot = findRegMed(z) ; 
		 }
		 else
		 {
			 pivot = findOtherMed(a) ; 
		 }
	     
	     int i = from - 1;
	     int j = to + 1;
	     while (i < j)
	     {
	        i++; while (a[i] < pivot) { i++; }
	        j--; while (a[j] > pivot) { j--; }
	        if (i < j) { swap(a, i, j); }
	     }
	     return j;
	 }
	
	 public static void swap(int[] a, int i, int j)
	 {
	   int temp = a[i];
	   a[i] = a[j];
	   a[j] = temp;
	 }
	
	public static void main(String [] args)
	{
		QuickSorter qs = new QuickSorter(16) ; 
		//qs.printArray();
		//System.out.println(); 
		//System.out.println(QuickSorter.findOtherMed(qs.arr)) ; 
		
		
		int[] array = {3,5,3,8,6,4,3,5,20} ; 
		QuickSorter mg = new QuickSorter(array) ; 
		System.out.println(mg.findRegMedian()) ; 
		
		int[] array1 = {5,6,4,7,9,5,4,3,5,7,5,4} ; 
		QuickSorter mg1 = new QuickSorter(array1) ; 
		System.out.println(mg1.findRegMedian()) ; 
		
		int[] array2 = {5,6,4,4,4,5,4,3,5,7,5,4} ; 
		QuickSorter mg2 = new QuickSorter(array2) ; 
		System.out.println(mg2.findRegMedian()) ; 
		
		int[] array3 = {5,5,4,5,5,5,4,3,5,7,5,4} ; 
		QuickSorter mg3 = new QuickSorter(array3) ; 
		System.out.println(mg3.findRegMedian()) ;
		
	}	
}
