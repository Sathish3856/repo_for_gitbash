package task.assignment;

import java.util.Arrays;
import java.util.TreeSet;

public class ArrayProgram {

	public static void main(String[] args) 
	{

		int[] a = {5,3,0,1,2};
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
