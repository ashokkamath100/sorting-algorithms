import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeTester 
{

	@Test
	void test() 
	{
		int[] array = {3,5,3,8,6,4,3,5,20} ; 
		MergeSorter mg = new MergeSorter(array) ; 
		assertEquals("3 3 3 4 5 5 6 8 20 ",mg.complete()) ; 
		
		int[] array1 = {5,6,4,7,9,5,4,3,5,7,5,4} ; 
		MergeSorter mg1 = new MergeSorter(array1) ; 
		assertEquals("3 4 4 4 5 5 5 5 6 7 7 9 ", mg1.complete()) ; 
		
		int[] array2 = {5,6,4,4,4,5,4,3,5,7,5,4} ; 
		MergeSorter mg2 = new MergeSorter(array2) ; 
		assertEquals("3 4 4 4 4 4 5 5 5 5 6 7 ", mg2.complete()) ; 
		
		int[] array3 = {5,5,4,5,5,5,4,3,5,7,5,4} ; 
		MergeSorter mg3 = new MergeSorter(array3) ; 
		assertEquals("3 4 4 4 5 5 5 5 5 5 5 7 ", mg3.complete()) ;
		
		
		
	}

}
