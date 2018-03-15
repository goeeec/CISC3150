public class NQueen
{
	public int		size;
	public int[][]	board;
	public int		count;

	public boolean isValid(int row, int col)
	{
		int		i, j;

		// check same column from top to current row
		for (i = 0; i < row; i++)
		{
			if (board[i][col] == 1)
				return (false);
		}

		// check diagonal from current position to upper left corner
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
		{
			if (board[i][j] == 1)
				return (false);
		}

		// check diagonal from current position to upper right corner
		for (i = row, j = col; i >= 0 && j < size; i--, j++)
		{
			if (board[i][j] == 1)
				return (false);
		}

		return (true);
	}

	public void nQueenSolver(int row)
	{
		// this means the current board is finished
		if (row == size)
		{
			// print board logic
			for (int i = 0; i < size; i++)
			{
				for (int j = 0; j < size; j++)
					System.out.printf("%d ", board[i][j]);
				System.out.printf("\n");
			}
			System.out.printf("\n");
			count++;
			return;
		}
		else
		{
			for (int i = 0; i < size; i++)
			{
				// check if the intended move is valid
				if (isValid(row, i))
				{
					// place the queen
					board[row][i] = 1;

					// recursive call to place queen to next row
					nQueenSolver(row + 1);

					// if the previous placement is not correct
					// wipe it out and retry
					board[row][i] = 0;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		NQueen	nq = new NQueen();
		nq.size = Integer.parseInt(args[0]);
		if (nq.size < 4)
		{
			if (nq.size == 1)
			{
				System.out.printf("1\nAll possible solution(s): 1\n");
				System.exit(0);
			}
			System.out.println("No solutions for this size");
			System.exit(0);
		}
		nq.board = new int[nq.size][nq.size];
		nq.nQueenSolver(0);
		System.out.println("All possible solution(s): " + nq.count);
	}
}

/*
reference:
https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
http://www.techiedelight.com/print-possible-solutions-n-queens-problem/
*/
