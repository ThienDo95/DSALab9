package v1;

import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 9 
 * Status: Complete and thoroughly tested
 * Last update: 04/03/2017
 * Submitted:  04/06/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 04/03/2017
 */
public class Sorting
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException
	{
		int i;
		Integer array[] = new Integer [8];
		array[0] = 8;
		array[1] = 7;
		array[2] = 6;
		array[3] = 5;
		array[4] = 4;
		array[5] = 3;
		array[6] = 2;
		array[7] = 1;
		
		
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Bubble Sort");
			System.out.println("2. Improved Bubble Sort");
			System.out.println("3. Selection Sort");
			System.out.println("4. Improved Selection Sort");
			System.out.println("5. Insertion Sort");
			System.out.println("6. Exist");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 7)
			{
				switch(i)
				{
					case 1:
						System.out.println("Bubble Sorting");
						bSorting(array);
						break;
					case 2:
						System.out.println("Improved Bubble Sorting");
						ibSorting(array);
						break;
					case 3:
						System.out.println("Selection Sorting");
						sSorting(array);
						break;
					case 4:
						System.out.println("Improved Selection Sorting");
						isSorting(array);
						break;
					case 5:
						System.out.println("Insertion Sorting");
						iSorting(array);
						break;
					case 6:
						System.out.println("PEACE");
						break;				
				}
			}
		}while(i < 6 || i > 6);
}
	
	//Bubble Sorting
	protected static void bSorting(Integer [] a)
	{
		display(a, "Before Sorting: ");
		
		int count = a.length;
		int comparisions = 0;
		int swaps = 0;
		int passes = a.length - 1;
		
		while(count >= 1)
		{
			for (int c = 0; c < passes; c++)
			{
				if (a[c] > a[c + 1])
				{
					swaps++;
					int temp = a[c];
					a[c] = a[c + 1];
					a[c + 1] = temp;
				}
				
				comparisions++;
			}
			
			passes--;
			count--;
		}
		
		display(a, "After Sorting: ");
		System.out.println("Number of comparisions: " + comparisions);
		System.out.println("Number of swaps: " + swaps);
	}
	
	//Improved Bubble Sorting
	protected static void ibSorting(Integer [] a)
	{
		display(a, "Before Sorting: ");
		
		int length = a.length;
		int comparisions = 0;
		int swaps = 0;
		int passes = a.length - 1;
		boolean isSwap = true;
		
		while(length > 1)
		{
			for (int c = 0; c < passes; c++)
			{
				if (a[c] > a[c + 1])
				{
					isSwap = false;
					swaps++;
					int temp = a[c];
					a[c] = a[c + 1];
					a[c + 1] = temp;
				}
				
				comparisions++;
			}
			
			if(isSwap == true)
			{
				length = 1;
			}
			else
			{
				isSwap = true;
			}
			
			passes--;
			length--;
		}
		
		display(a, "After Sorting: ");
		System.out.println("Number of comparisions: " + comparisions);
		System.out.println("Number of swaps: " + swaps);
	}
	
	//Selection Sorting
	protected static void sSorting(Integer [] a)
	{
		display(a, "Before Sorting: ");
		
		int i = 0;
		int j = 0;
		int s = 0;
		int temp = 0;
		int comparisions = 0;
		int swaps = 0;
		
		for(i = 0; i < a.length - 1; i++)
		{
			s = i;
			
			for(j = a.length - 1; j > i; j--)
			{
				comparisions++;
				if(a[j] < a[s])
				{
					s = j;
				}
			}
			
			
				temp = a[s];
				a[s] = a[i];
				a[i] = temp;
			
				swaps++;
			
		}
		
		display(a, "After Sorting: ");
		System.out.println("Number of comparisions: " + comparisions);
		System.out.println("Number of swaps: " + swaps);
	}
	
	//Improved Selection Sorting
	protected static void isSorting(Integer [] a)	
	{
		display(a, "Before Sorting: ");
		
		int i = 0;
		int j = 0;
		int s = 0;
		int temp = 0;
		int size = a.length;
		int comparisions = 0;
		int swaps = 0;
		boolean isSwap = true;
		
		for(i = 0; i < a.length - 1; i++)
		{
			s = i;
			
			for(j = a.length - 1; j > i; j--)
			{
				comparisions++;
				if(a[j] < a[s])
				{
					s = j;
					isSwap = false;
				}
			}
			
			temp = a[s];
			a[s] = a[i];
			a[i] = temp;
			
			swaps++;
			
			if(isSwap == true)
			{
				i = size;
			}
			else
			{
				isSwap = true;
			}
		}
		
		display(a, "After Sorting: ");
		System.out.println("Number of comparisions: " + comparisions);
		System.out.println("Number of swaps: " + swaps);
	}

	//Insertion Sorting
	protected static void iSorting(Integer [] a)
	{
		display(a, "Before Sorting: ");
		
		int item = 0;
		int currItem = 0;
		int count = 0;
		int comparisions = 0;
		int swaps = 0;
		
		for(item = 1; item < a.length; item++)
		{
			currItem = a[item];
			
			for(count = item - 1; (count >= 0) && (a[count] > currItem); count--)
			{
				a[count + 1] = a[count];
				comparisions++;
				swaps++;
			}
			
			swaps++;
			a[count + 1] = currItem;
		}
		
		display(a, "After Sorting: ");
		System.out.println("Number of comparisions: " + comparisions);
		System.out.println("Number of swaps: " + swaps);
	}
	
	//Still working on it
	protected static void iiSorting(Integer [] a)
	{
		display(a, "Before Sorting: ");
		
		int item = 0;
		int currItem = 0;
		int count = 0;
		int comparisions = 0;
		int swaps = 0;
		
		for(item = 1; item < a.length; item++)
		{
			currItem = a[item];
			
			for(count = item - 1; (count >= 0) && (a[count] > currItem); count--)
			{
				a[count + 1] = a[count];
				comparisions++;
				swaps++;
			}
			
			swaps++;
			a[count + 1] = currItem;
		}
		
		display(a, "After Sorting: ");
		System.out.println("Number of comparisions: " + comparisions);
		System.out.println("Number of swaps: " + swaps);
	}
	
	
	private static void display(Integer [] a, String data)
	{
		System.out.println(data);
		for (int c = 0; c < a.length; c++)
		{
			System.out.println(a[c]);
		}
	}
}
