public class Main
{
	public static void main(String[] args)
	{
		char[] chars1 = {'H', 'e', 'l', 'l', 'o', 'h', 'e', 'l', 'l', 'o'};
		char[] chars2 = {'H', 'e', 'L', 'L', 'o'};
		MyString	mystr1 = new MyString(chars1);
		MyString	mystr2 = new MyString(chars2);

		System.out.printf("charAt(int index): %c\n", mystr1.charAt(3));
		System.out.printf("length(): %d\n", mystr1.length());
		System.out.printf("substring(int begin, int end): %s\n",
							mystr1.substring(3, 8).toString());
		System.out.printf("toLowerCase(): %s\n", mystr2.toLowerCase().toString());
		System.out.printf("toUpperCase(): %s\n", mystr1.toUpperCase().toString());
		System.out.printf("equals(MyString s): %b\n", mystr1.equals(mystr2));
		System.out.printf("getMyString(): %s\n", mystr1.getMyString().toString());
		System.out.printf("toString(): %s\n", mystr1.toString());
		System.out.printf("valueOf(int i): %s\n", MyString.valueOf(2335).toString());
		System.out.printf("valueOf(int i ): %s\n", MyString.valueOf(-111334).toString());
	}
}
