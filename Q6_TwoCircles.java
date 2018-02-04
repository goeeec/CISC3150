import java.util.*;
import java.awt.*;
import java.lang.Math;

public class Q6_TwoCircles
{
	public static void main(String[] args)
	{
		Scanner		input = new Scanner(System.in);
		Point[]		center = new Point[2];
		double[]	radius = new double[2];
		int			x, y;
		double		centerDistance;

		// 0: prompts the user to enter the center coordinates and 
		// radiuses of two circles
		for (int i = 0; i < 2; i++)
		{
			System.out.format("Circle %d center-x: ", i);
			x = input.nextInt();
			System.out.format("Circle %d center-y: ", i);
			y = input.nextInt();
			center[i] = new Point(x, y);
			System.out.format("Circle %d radius: ", i);
			radius[i] = input.nextDouble();
			System.out.format("Circle %d has a center at (%d,%d)"
								+ " and a radius of %.3f\n",
								i, center[i].x, center[i].y, radius[i]);
		}

		// 1: Determine the relationship between two circles
		centerDistance = Math.sqrt(Math.pow(center[1].x - center[0].x, 2)
									+ Math.pow(center[1].y - center[0].y, 2));
		System.out.println("Distance between two centers: " + centerDistance);
		// (0)separate from each other
		if (radius[0] + radius[1] < centerDistance)
			System.out.println("Two circles are separated from each other");
		// (1)touching each other
		else if (radius[0] + radius[1] == centerDistance ||
				Math.abs(radius[0] - radius[1]) == centerDistance)
			System.out.println("Two circles are touching each other");
		// (2)overlapping each other
		else if (radius[0] + radius[1] > centerDistance &&
				Math.abs(radius[0] - radius[1]) < centerDistance)
			System.out.println("Two circles are overlapping each other");
		// (3)completely within one another
		else
			System.out.println("One circle is completely within the other");
	}
}

/*
 * Relationship of two circles:
 * https://www.bbc.co.uk/education/guides/z9pssbk/revision/4
 */
