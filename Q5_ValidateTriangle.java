import java.util.*;
import java.awt.*;
import java.lang.Math;

public class Q5_ValidateTriangle
{
	public static void main(String[] args)
	{
		Scanner 	input = new Scanner(System.in);
		Point[]		triangle = new Point[3];
		double[]	sides = new double[3];
		int			x, y;
		boolean		isTriangle;

		// 0: reads three 2D points A, B, and C from the user
		for (int i = 0; i < 3; i++)
		{
			System.out.println("Enter x coordinate for point " + i);
			x = input.nextInt();
			System.out.println("Enter y coordinate for point " + i);
			y = input.nextInt();
			triangle[i] = new Point(x, y);
			System.out.format("Point %d is set at %d,%d\n",
								i, triangle[i].x, triangle[i].y);
		}

		// 1: calculate the length of each side of the triangle
		// formula: sqrt((x2-x1)^2+(y2-y1)^2)
		sides[0] = Math.sqrt(Math.pow(triangle[1].x - triangle[0].x, 2)
						+ Math.pow(triangle[1].y - triangle[0].y, 2));
		sides[1] = Math.sqrt(Math.pow(triangle[2].x - triangle[1].x, 2)
						+ Math.pow(triangle[2].y - triangle[1].y, 2));
		sides[2] = Math.sqrt(Math.pow(triangle[2].x - triangle[0].x, 2)
						+ Math.pow(triangle[2].y - triangle[0].y, 2));

		System.out.format("Side 0: %.3f\n", sides[0]);
		System.out.format("Side 1: %.3f\n", sides[1]);
		System.out.format("Side 2: %.3f\n", sides[2]);

		// 2: determine if it's a real triangle
		isTriangle = (sides[0] + sides[1] > sides[2]
					&& sides[1] + sides[2] > sides[0]
					&& sides[0] + sides[2] > sides[1]);
		if (isTriangle)
			System.out.println("This is a real triangle");
		else
			System.out.println("This is NOT a triangle");
	}
}


/*
 * Declaring an array of objects:
 * https://www.cs.usfca.edu/~wolber/courses/110/lectures/ArrayOfObjs.htm
 * Formatting numeric outputs:
 * https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
 */
