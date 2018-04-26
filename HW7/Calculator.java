import java.util.*;
import java.lang.Exception;
// testing: \( 1 + 2 \) "*" 3 + 4 "/" \( 5 + 6 "*" 7 \) - 8

public class Calculator {
	public static void main(String[] args) throws Throwable{
		String expr;

		try {
			expr = toPostfix(args);
			double res = evaluateExpression(expr);
			System.out.printf("Result: %.3f\n", res);
		} catch(ArithmeticException ae) {
			System.out.println("Cannot divide by zero");
		} catch(AlgebraFailException afe) {
			System.out.println("Please enter a valid expression");
		} catch(QuitMashingOnYourKeyboardException qe) {
			System.out.println("Please enter valid operator");
		} catch(UserIsADumbassException ue) {
			System.out.println("Please enter numbers");
		}
	}

	public static String toPostfix(String[] args) {
		StringBuilder output = new StringBuilder();
		Stack<Character> operator = new Stack<Character>();

		int count = 0;

		for (String s : args) {
			// should be number for every other argument
			if (count % 2 == 0) {
				// check if current argument is a number
				if (isNumeric(s)) {
					output.append(s);
					output.append(' ');
				} else {
					throw new AlgebraFailException();
				}
			} else { // this part should be either parentheses or operators
				char op = s.charAt(0);
				if (op == '(') {
					operator.push(op);
				} else if (op == ')') { // if closing, pop all operator until it meets the opening
					while (operator.peek() != '(') {
						output.append(operator.pop());
						output.append(' ');
					}
					// pop out the opening (
					operator.pop();
				} else if (isOperator(op)) { // check if current argument is operator
					// while operator stack is not empty
					while (!operator.isEmpty()) {
						char topOp = operator.peek();
						// condition to pop the stack:
						// if top op is greater than current op,
						// or top op is same as current op and is left associative
						if (getPrecedence(topOp) > getPrecedence(op)
							|| (getPrecedence(topOp) == getPrecedence(op) && op != '^')) {
							output.append(operator.pop());
							output.append(' ');
							//System.out.printf("Popped: %c\n", topOp);
						} else
							break;
					}
					operator.push(op);
					//System.out.printf("Pushed: %c\n", op);
				}
			}
		}
		while (!operator.isEmpty()) {
			output.append(operator.pop());
			output.append(' ');
		}
		return output.toString();
	}

	public static double evaluateExpression(String s) {
		String[] elements = s.split(" ");
		Stack<Double> operands = new Stack<Double>();

		double operand1;
		double operand2;
		char operator;
		double res;

		for (String e : elements) {
			if (isNumeric(e)) {
				operands.push(Double.valueOf(e));
			} else {
				operand2 = operands.pop();
				operand1 = operands.pop();
				operator = e.charAt(0);
				res = operation(operand1, operand2, operator);
				operands.push(res);
			}
		}
		return operands.pop();
	}

	public static double operation(double op1, double op2, char operator) {
		switch(operator) {
			case '+':
				return op1 + op2;
			case '-':
				return op1 - op2;
			case '*':
				return op1 * op2;
			case '/':
				if (op2 == 0)
					throw new ArithmeticException();
				else
					return op1 / op2;
			case '^':
				return Math.pow(op1, op2);
			default:
				return 0.0;
		}
	}

	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		else
			return false;
	}

	public static boolean isNumeric(String s) {
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 48 || s.charAt(i) > 57)
				return false;
		}
		return true;
	}

	public static int getPrecedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 2;
		case '*':
		case '/':
			return 3;
		case '^':
			return 4;
		default:
			return 0;
		}
	}
}

/* 
Shunting yard algorithm:
https://en.wikipedia.org/wiki/Shunting-yard_algorithm
https://www.sanfoundry.com/java-program-shunting-yard-algorithm/
https://rosettacode.org/wiki/Parsing/Shunting-yard_algorithm#Java

Evaluation of postfix expression:
https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/

Cannot use asterisk on command line argument:
https://stackoverflow.com/questions/2718873/the-issue-of-in-command-line-argument
*/