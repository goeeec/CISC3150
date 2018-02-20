public final class MyString
{
	private final char[] chars;

	public MyString(char[] chars)
	{
		this.chars = chars;
	}

	public char charAt(int index)
	{
		return (this.chars[index]);
	}

	public int length()
	{
		return (this.chars.length);
	}

	public MyString substring(int begin, int end)
	{
		if (begin < 0 || end < 0 || begin > end)
		{
			System.err.println("Invalid input");
			return (null);
		}
		char[] str = new char[end - begin];
		for (int i = 0; i < str.length; i++)
			str[i] = this.chars[begin + i];
		return (new MyString(str));
	}

	public MyString toLowerCase()
	{
		char[] str = new char[this.chars.length];

		for (int i = 0; i < this.chars.length; i++)
		{
			if (chars[i] > 64 && chars[i] < 91)
				str[i] = (char)(chars[i] + 32);
			else
				str[i] = chars[i];
		}
		return (new MyString(str));
	}

	public MyString toUpperCase()
	{
		char[] str = new char[this.chars.length];

		for (int i = 0; i < this.chars.length; i++)
		{
			if (chars[i] > 96 && chars[i] < 123)
				str[i] = (char)(chars[i] - 32);
			else
				str[i] = chars[i];
		}
		return (new MyString(str));
	}

	public boolean equals(MyString s)
	{
		if (this.chars.length != s.length())
			return (false);
		for (int i = 0; i < this.chars.length; i++)
		{
			if (chars[i] != s.charAt(i))
				return (false);
		}
		return (true);
	}

	public MyString getMyString()
	{
		return (new MyString(this.chars));
	}

	public String toString()
	{
		return (new String(this.chars));
	}

	public static MyString valueOf(int i)
	{
		char[]	result;
		int		temp = i;
		int		len = 0;
		boolean	isNegative = false;

		if (temp < 0)
		{
			isNegative = true;	// set flag for negative number
			len++;			// add one space to put '-'
			i *= -1;		// change back to positive number
		}

		// find length of the number
		while (temp != 0)
		{
			len++;
			temp /= 10;
		}
		result = new char[len];

		// assign digit by digit
		while (i != 0)
		{
			result[--len] = (char)(i % 10 + 48);
			i /= 10;
		}

		// add the negative sign at the beginning
		if (isNegative)
			result[0] = '-';
		return (new MyString(result));
	}
}
