public class Q1_FindPi
{
	public static void main(String[] args)
	{
		long 	before = System.currentTimeMillis();
		int		radius = 3;
		long	nDots = 4000000000L;
		double	x, y;
		long	insideCircle = 0;
		double	approximateRatio;

		for (long i = 0; i < nDots; i++)
		{
			// randomly generate the point's coordinate
			x = Math.random() * radius;
			y = Math.random() * radius;

			// use the distance formula to calculate the point's distance from center
			if ((Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(radius, 2))
				insideCircle++;
		}
		approximateRatio = (double)insideCircle / (double)nDots;
		System.out.println("Estimated PI: " + (4 * approximateRatio));
		System.out.println(System.currentTimeMillis() - before);
	}

}
/*
Monte Carlo method:
https://www.geeksforgeeks.org/estimating-value-pi-using-monte-carlo/
*/
