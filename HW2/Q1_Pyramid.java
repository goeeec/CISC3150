import java.util.*;

public class Q1_Pyramid
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int		height;
		int		space;
		int		number;
		
		System.out.printf("Please enter the height of the pyramid\n");
		height = input.nextInt();
		space = height * 2 - 2;
		System.out.printf("Here is the pyramid with height: %d\n", height);
		for (int i = 1; i <= height; i++)
		{
			if (space > 0)
				System.out.printf("%" + space + "s", "");
			for (number = 0; number < i; number++)
				System.out.printf("%d ", number + 1);
			for (number -= 2; number >= 0; number--)
				System.out.printf("%d ", number + 1);
			System.out.printf("\n");
			space -= 2;
		}
	}
}
