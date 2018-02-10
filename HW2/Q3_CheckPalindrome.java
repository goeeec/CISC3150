import java.util.*;

public class Q3_CheckPalindrome
{
	public static void main(String[] args)
	{
		int		pos;
		char[]	letter;
		String	str;
		Scanner input = new Scanner(System.in);
		
		// prompt to enter string for checking
		System.out.println("Please enter a string");
		str = input.next();
		letter = new char[str.length() / 2];

		// push first half string into array
		for (pos = 0; pos < str.length() / 2; pos++)
			letter[pos] = str.charAt(pos);

		// for odd number length string, skip the letter in the middle
		if (str.length() % 2 == 1)
			pos++;

		// verify the second half string with the letter in array
		for (int i = letter.length - 1; i >= 0; i--, pos++)
		{
			// if at any point, they don't match, then the string is not palindrome
			if (letter[i] != str.charAt(pos))
			{
				System.out.println("This is NOT a palindrome");
				System.exit(0);
			}
		}
		System.out.println("This IS a palindrome");
	}
}

/*
 * String class method charAt():
 * https://docs.oracle.com/javase/7/docs/api/
 */
