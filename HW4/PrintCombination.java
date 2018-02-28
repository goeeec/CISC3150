import java.util.Scanner;
import java.io.*;

public class PrintCombination
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(new File("input.txt"));
		int		mapRow;
		int		mapCol;
		int		combCount = 1;	// variable to store the number of all combinations
		
		// Setting up the map
		mapRow = input.nextInt();
		char[][]	map = new char[mapRow][];
		for (int i = 0; input.hasNext(); i++)
		{
			mapCol = input.nextInt();
			combCount *= mapCol;
			map[i] = new char[mapCol];
			for (int j = 0; j < mapCol; j++)
				map[i][j] = input.next().charAt(0);
		}
		// printMap(map);


		/* Explanation for my approach
		 * Ex:
		 * Original:		Inverted CombMap:
		 * a b c			a a a a b b b b c c c c
		 * d e		-->		d d e e d d e e d d e e
		 * f g				f g f g f g f g f g f g
		 * Total Combination Count = 3 * 2 * 2 = 12
		 * It will be easier to print all the combinations inverted
		 * because there is a pattern for each row:
		 * map[0] elements are each printed combCount/map[0].length = 4 consecutive times
		 * map[1] elements: combCount/map[0].length/map[1].length = 2
		 * map[2] elements: .../map[2].length = 1
		 * so, after having a inverted combMap
		 * the normal combMap can be easily obtained
		 */
		// Creating combination map
		char[][]	combMap = new char[mapRow][combCount];
		int		headPos;	// the char that should be printing
		int		printCount = combCount;		// the consecutive time each char needed to print
		int		nPrint;		// print counter
		for (int row = 0; row < mapRow; row++)
		{
			printCount /= map[row].length;
			headPos = 0;
			nPrint = 0;
			// as long as that row still has space, repeat to print the elements once again
			for (int col = 0; col < combCount; col++)
			{
				combMap[row][col] = map[row][headPos];
				nPrint++;
				if (nPrint >= printCount)
				{
					// if the last element is printed, start over at the first
					if (headPos + 1 == map[row].length)
						headPos = 0;
					else
						headPos++;
					// reset the print counter to ensure each element is printed the same number of times
					nPrint = 0;
				}
			}
		}
		// printMap(combMap);
		printInvertedMap(combMap);
	}
/*
Function to print the map normally
	public static void printMap(char[][] map)
	{
		for (int row = 0; row < map.length; row++)
		{
			for (int col = 0; col < map[row].length; col++)
				System.out.printf("%c ", map[row][col]);
			System.out.printf("\n");
		}
	}
*/
	public static void printInvertedMap(char[][] map)
	{
		for (int row = 0; row < map[0].length; row++)
		{
			for (int col = 0; col < map.length; col++)
				System.out.printf("%c", map[col][row]);
			System.out.printf("\n");
		}
	}
}


/*
 * Declaring 2D array:
 * https://stackoverflow.com/questions/12231453/syntax-for-creating-a-two-dimensional-array
 *
 * I was not able to open the file, keeps saying filenotfoundexception:
 * https://stackoverflow.com/questions/19788989/error-unreported-exception-filenotfoundexception-must-be-caught-or-declared-to
 */
