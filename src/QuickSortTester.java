import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuickSortTester {

	@Test
	void test() 
	{
		int[] array = {3,5,3,8,6,4,3,5,20} ; 
		QuickSorter mg = new QuickSorter(array) ; 
		assertEquals(6,mg.findRegMedian()) ; 
		
		int[] array1 = {5,6,4,7,9,5,4,3,5,7,5,4} ; 
		QuickSorter mg1 = new QuickSorter(array1) ; 
		assertEquals(5, mg1.findRegMedian()) ; 
		
		int[] array2 = {5,6,4,4,4,5,4,3,5,7,5,4} ; 
		QuickSorter mg2 = new QuickSorter(array2) ; 
		assertEquals(5, mg2.findRegMedian()) ; 
		
		int[] array3 = {5,5,4,5,5,5,4,3,5,7,5,4} ; 
		QuickSorter mg3 = new QuickSorter(array3) ; 
		assertEquals(5, mg3.findRegMedian()) ; 
	}

}
