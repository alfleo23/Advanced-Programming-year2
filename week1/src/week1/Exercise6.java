package week1;

public class Exercise6 {

	public static void main(String[] args) 
	{
		int x = 0;
		int [] arry = {1,2,3,4,5,6};
		//System.out.println("value at position 0 is: "+ arry[0]);
		
		for (int i = 0; i<6; i++)
		{
			System.out.println("value at position "+ i + " is "+ arry[i]);
			
		}
		
		System.out.println("");
		
		for (int i = 0; i<6; i++)
		{
			arry[i] = x;
			x = x+2;
			System.out.println("value at position "+ i + " is "+ arry[i]);
		}

	}

}
