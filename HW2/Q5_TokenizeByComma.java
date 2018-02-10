import java.util.*;

public class Q5_TokenizeByComma
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		input.useDelimiter(",");
		System.out.println("Please enter string separated by comma for tokenization");
		while (input.hasNext())
			System.out.println(input.next());
	}
}

/*
 * useDelimiter method:
 * https://docs.oracle.com/javase/7/docs/api/
 */
