import java.util.*;

public class Q2_Calendar
{
	public static void main(String[] args)
	{
		int		year;
		int		month;
		int		day;
		int		maxDay = 0;
		int		nSpace;
		int		date;
		int		headerLength;
		String[] months = {"January", "February", "March", "April", "May",
							"June", "July", "August", "September", "October",
							"November", "December"};
		Scanner input = new Scanner(System.in);

		System.out.printf("Please enter the year\n");
		year = input.nextInt();
		System.out.printf("What day is 1/1?\n");
		System.out.printf("Sun = 0, Mon = 1, Tue = 2, Wed = 3, Thu = 4, "
							+ "Fri = 5, Sat = 6\n");
		date = input.nextInt();
		System.out.printf("Year: %d Date: %s\n", year, date);

		// MAIN body to print calendar
		for (month = 1; month <= 12; month++)
		{
			// 0: Print month's header
			// centering header by calculating the total space needed
			headerLength = months[month - 1].length() 
							+ Integer.toString(year).length() + 1;
			// than push the whole string rightward by adding leading space
			nSpace = (20 - headerLength) / 2;
			if (nSpace > 0)
				System.out.printf("%" + nSpace + "s", "");
			System.out.printf("%" + headerLength + "s\n", 
							months[month - 1] + " " + year);

			// 1: Print week header
			System.out.printf("Su Mo Tu We Th Fr Sa\n");

			// 2: Print days
			// assign the maximum day for each month
			switch (month)
			{
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					maxDay = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					maxDay = 30;
					break;
				case 2:
					if (year % 4 == 0)
						maxDay = 29;
					else
						maxDay = 28;
					break;
				default:
					break;
			}
			// loop to print days
			for (day = 1; day <= maxDay; day++)
			{
				// need to add space if the first day doesn't start on sunday
				nSpace = date * 3;
				if (nSpace > 0 && day == 1)
					System.out.printf("%" + nSpace + "s", "");
				System.out.printf("%2d ", day);
				// start on new line if a week ends
				if (date == 6)
				{
					// avoid adding one extra line if months ends with week
					if (day != maxDay)
						System.out.printf("\n");
					date = 0;
				}
				else
					date++;
			}
			System.out.printf("\n");
		}
	}
}

/*
 * String casting in java:
 * http://javadevnotes.com/java-integer-to-string-examples
 */
