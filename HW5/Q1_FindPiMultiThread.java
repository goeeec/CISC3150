import java.util.concurrent.*;

public class Q1_FindPiMultiThread extends Thread
{
	private long nDotsPerThread;
	private long insideCirclePerThread;

	Q1_FindPiMultiThread()
	{ this.nDotsPerThread = 400000; }

	Q1_FindPiMultiThread(long nDots)
	{ this.nDotsPerThread = nDots; }

	public long getInsideCirclePerThread()
	{ return (this.insideCirclePerThread); }

	public static void main(String[] args)
	{
		long 	before = System.currentTimeMillis();
		long	nDots = 4000000000L;
		long	insideCircle = 0;

		Q1_FindPiMultiThread[] thread = new Q1_FindPiMultiThread[4];
		for (int i = 0; i < 4; i++)
		{
			thread[i] = new Q1_FindPiMultiThread(nDots / 4);
			thread[i].start();
		}

		try
		{
			for (int i = 0; i < 4; i++)
			{
				thread[i].join();
				insideCircle += thread[i].getInsideCirclePerThread();
			}

		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}

		System.out.println("Estimated PI: " + (4 * ((double)insideCircle / nDots)));
		System.out.println(System.currentTimeMillis() - before);
	}

	public void run()
	{
		double	x, y;

		ThreadLocalRandom rand = ThreadLocalRandom.current();

		for (long i = 0; i < nDotsPerThread; i++)
		{
			x = rand.nextDouble();
			y = rand.nextDouble();

			if (x * x + y * y <= 1)
				(this.insideCirclePerThread)++;
		}
	}
}

/*
Multithreading:
https://www.tutorialspoint.com/java/java_multithreading
ThreadLocalRandom:
https://dzone.com/articles/java-7-how-write-really-fast
*/
