import java.util.*;

public class Q2_calcArea
{
	public static void main(String[] args)
	{
		double	radius = 0.00;
		Scanner	input = new Scanner(System.in);

		System.out.println("Please enter radius");
		while (input.hasNextDouble())
		{
			radius = input.nextDouble();
			if (radius <= 0)
				System.err.println("Please enter positive number");
			else
				System.out.println("Circle's area: " 
				+ (Math.pow(radius, 2) * Math.PI));
			System.out.println("Please enter radius");
		}
	}
}
