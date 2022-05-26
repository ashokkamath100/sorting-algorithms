import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class MergeSorter 
{
	int[] arr ; 
	int[][] ordered ; 
	int[][] cleaned ;
	ArrayList<Integer> holder ; 
	int[] finalArr ; 
	int arrSize = 0 ; 
	
	public MergeSorter(int arrSize)
	{
		this.arrSize = arrSize ; 
		arr = new int[arrSize] ; 
		for(int i = 0 ; i < arrSize ; i++)
		{
			arr[i] = (int)(Math.random() * 50) + 1 ; 
		}
	}
	
	public MergeSorter(int[] arr)
	{
		this.arr = arr ; 
		this.arrSize = arr.length ; 
	}
	
	public void printClean()
	{
		System.out.println() ; 
		//System.out.println("Decreasing and Nondecreasing Segments") ; 
		for(int i = 0 ; i < cleaned.length ; i++)
		{
			if(cleaned[i][0] != 0)
			{
				System.out.println() ;
			}
			for(int k = 0 ; k < cleaned[0].length ; k++)
			{
				
				if(cleaned[i][k] != 0)
				{
					System.out.print(cleaned[i][k] + " ") ; 
				}
			}
		}
		System.out.println() ; 
		System.out.println() ; 
	}
	public void printFinal()
	{
		System.out.println() ; 
		System.out.println("My final array") ; 
		for(int i = 0 ; i < finalArr.length ; i++)
		{
			
			System.out.println() ;
			for(int k = 0 ; k < finalArr.length ; k++)
			{
				 
				if(finalArr[i] != 0)
				{
					System.out.print(finalArr[i]+ " ") ;
				}
			}
		}
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
		System.out.println() ; 
	}
	public void print2dArray()
	{
		System.out.println() ; 
		System.out.println("My 2d array") ; 
		for(int i = 0 ; i < ordered.length ; i++)
		{
			
			System.out.println() ;
			for(int k = 0 ; k < ordered[0].length ; k++)
			{
				
				if(ordered[i][k] != 0)
				{
					System.out.print(ordered[i][k] + " ") ; 
				}
			}
		}
	}
	
	public void sort()
	{
		boolean decreasing = true ; 
		ordered = new int[arrSize][arrSize] ; 
		
		int row = 0 ; 
		int col = 0 ; 
		for(int i = 0 ; i < ordered.length ; i++)
		{
			int x = arr[i] ; 
			//add first two elements from starting index 
			if(col <= 1 )
			{
				//System.out.println(row) ; 
				//System.out.println(col) ; 
			
				ordered[row][col] = arr[i] ; 
				//System.out.print(ordered[row][col] + ", ") ; 
				if(col ==1)
				{
					if(ordered[row][1] >= ordered[row][0])
					{
						decreasing = false ; 
					}
					else
					{
						decreasing = true ; 
					}
				}
				col++ ;
				
			}//after doing above, check if decreasing or nondecreasing
			else if(col > 1)
			{
				if(decreasing)
				{
					if(col > 0)
					{
						if(arr[i] < ordered[row][col-1])
						{
							ordered[row][col] = arr[i] ; 
							//System.out.print(ordered[row][col]+ ", ") ; 
							col++ ; 
						}
						else
						{
							decreasing = false ; 
							row++ ; 
							col = 0 ; 
							ordered[row][col] = arr[i] ; 
							//System.out.println(ordered[row][col]+ ", ") ; 
							col++ ; 
						}
					}
				}
				else
				{
					if(arr[i] >= ordered[row][col-1])
					{
						ordered[row][col] = arr[i] ; 
						//System.out.print(ordered[row][col] + ", ") ; 
						col++ ; 
					}
					else
					{
						decreasing = true ; 
						row++ ; 
						col = 0 ; 
						ordered[row][col] = arr[i] ; 
						//System.out.println(ordered[row][col] + ", ") ; 
						col++ ; 
					}
				}
			}	
		}
		
	}
	public void reverse()
	{	
		int a = 0 ; 
		while(a < ordered.length)
		{
			int b = 0 ; 
			while(b < ordered[a].length)
			{
				boolean desc = true ; 
				int c = 0 ; 
				while(c < ordered[a].length - 1)
				{
					if(ordered[a][c] > ordered[a][c + 1] )
					{
						desc = false ; 
						int temp = ordered[a][c] ; 
						ordered[a][c] = ordered[a][c + 1] ; 
						ordered[a][c + 1] = temp ;
						
					}
					c++ ; 
				}
				b++ ; 
			}
			a++ ; 
		}
	}
	
	public void clean()
	{
		cleaned = new int[ordered.length][ordered[0].length] ; 
		for(int i = 0 ; i < cleaned.length ; i++)
		{
			int colIndex = 0 ; 
			for(int j = 0 ; j < cleaned[0].length ; j++)
			{
				if(ordered[i][j] != 0)
				{
					cleaned[i][colIndex] = ordered[i][j] ; 
					colIndex++ ; 
				}
			}
		}
	}
	public int[] merge()
	{
		 
		holder = new ArrayList<>() ;
		int frInd = 0 ; 
		int srInd = 0 ; 
		for(int i = 0 ; i < ordered.length ; i++)
		{
			for(int j = 0 ; j < ordered[0].length ; j++)
			{
				if(i == 0 && cleaned[i][j] != 0)
				{
					holder.add(cleaned[i][j]) ; 
					for(int x = 0 ; x < holder.size(); x++)
					{
						if(holder.get(x) != 0)
						{
							//System.out.print(holder.get(x) + " ") ; 
						}
						
					}
					//System.out.println(); 
				}
				else if(i > 0 && cleaned[i][j] != 0)
				{
					int a = findIndex(cleaned[i][j]) ; 
					if(a < 0)
					{
						holder.add(cleaned[i][j]) ; 
					}
					else
					{
						holder.add(a,cleaned[i][j]);
					}
					
					
					for(int x = 0 ; x < holder.size(); x++)
					{
						if(holder.get(x) != 0)
						{
							//System.out.print(holder.get(x) + " ") ; 
						}
						
					}
					//System.out.println(); 
				}
			}
		}
		System.out.println();
		int[] finalArr = new int[holder.size()] ; 
		for(int x = 0 ; x < holder.size(); x++)
		{
			if(holder.get(x) != 0)
			{
				//System.out.print(holder.get(x) + " ") ; 
				finalArr[x] = holder.get(x) ; 
			}
			
		}
		return finalArr ; 
	}
	public int findIndex(int num)
	{
		int index = 0 ; 
		for(int i = 0 ;i < holder.size(); i++)
		{
			if(num < holder.get(i))
			{
				index = i ; 
				return index ; 
			}
			
		}
		return -1   ; 
	}
	
	public String complete()
	{
		sort() ; 
		reverse() ; 
		clean() ; 
		return toString(merge()) ; 
	}
	
	public String toString(int[] arr)
	{
		String result = "" ; 
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			result += arr[i] + " " ; 
			System.out.println(result) ; 
		}
		
	return result ; 
	}
	public static void main(String[] args)
	{
		/*
		MergeSorter mg = new MergeSorter(50) ; 
		mg.printArray();
		mg.sort() ; 
		//mg.print2dArray(); 
		mg.reverse(); 
		mg.clean(); 
		//mg.print2dArray(); 
		//mg.printClean();
		mg.merge(); 
		*/
		
		int[] array = {3,5,3,8,6,4,3,5,20} ; 
		MergeSorter mg = new MergeSorter(array) ; 
		System.out.println(mg.complete()) ; 
		
		int[] array1 = {5,6,4,7,9,5,4,3,5,7,5,4} ; 
		MergeSorter mg1 = new MergeSorter(array1) ; 
		System.out.println(mg1.complete()) ; 
		
		int[] array2 = {5,6,4,4,4,5,4,3,5,7,5,4} ; 
		MergeSorter mg2 = new MergeSorter(array2) ; 
		System.out.println(mg2.complete()) ;
		
		int[] array3 = {5,5,4,5,5,5,4,3,5,7,5,4} ; 
		MergeSorter mg3 = new MergeSorter(array3) ; 
		System.out.println(mg3.complete()) ; 
	}
}
