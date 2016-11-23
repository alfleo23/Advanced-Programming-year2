package week2;
import java.util.Random;

public class ex3 {

	public static void main(String[] args) 
	{
		Random rand = new Random(); 
		
		for (int i=0; i < 5;i++)
		 {
		 System.out.print(rand.nextInt(10)+ " ");
		 } 
		
		System.out.println(" ");
		
		Random rand2 = new Random (System.currentTimeMillis());
		for (int i=0; i < 5;i++)
		{
		System.out.print(rand2.nextDouble()+ " ");
		}
	}

}
