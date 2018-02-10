import java.util.*;

/* Answer to Question:
 * To tokenize individual characters, I tried to set the delimiter to empty string
 * and this seems to be working
 */

public class Q6_TokenizeCharacters
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		input.useDelimiter("");
		System.out.println("Please enter string for tokenization of characters");
		while (input.hasNext())
			System.out.println(input.next());
	}
}

/*
 * useDelimiter method:
 * https://docs.oracle.com/javase/7/docs/api/
 */
