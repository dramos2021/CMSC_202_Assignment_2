/**@Author Diego Ramos
 * By Diego Ramos 3/3/22
 * A utility class for:
 *  1)converting algebraic expressions from infix to postfix.
 *  2)converting algebraic expressions from postfix to infix.
 *  3)exaluating infix expressions.
 * 
 */

public class Notation {
	
	
	
	/**converts infix notation to postfix notation that will take in a string 
	 * and returns a string
	 * @param a String infix representation
	 * @return a String postfix form
	 * @throws InvalidNotationFormatException if stack content at the end is incorrect.
	 * */
	
	public static String convertInfixToPostfix(String s) {
		MyQueue<String> postFixSolutionQueue = new MyQueue<String>(s.length());
		MyStack<String> stack = new MyStack<String>(s.length());
		
		for(int i=0; i < s.length(); i++) {
			
			if(Character.isDigit(s.charAt(i))) {
				postFixSolutionQueue.enqueue(Character.toString(s.charAt(i)));
				
			}
				
			else {
				switch(s.charAt(i)) {
				case '(': {stack.push(Character.toString(s.charAt(i)));;}break;
			
				case ')': while( !(((String)stack.top()).equals("("))) {
					
						postFixSolutionQueue.enqueue(stack.pop());
						
						
				}if(stack.size()>1)
				stack.pop();
				break;
					
				case '+':
				case '-':
				case '/':
				case '*':
					while (!stack.isEmpty()) {
						if(!isAnOperator(((String) stack.top()).charAt(0))) {
							stack.push(Character.toString(s.charAt(i)));
							break;
						}
							
						else
							if((operatorPrecedence(s.charAt(i)) <= operatorPrecedence(((String) stack.top()).charAt(0)))) 
							postFixSolutionQueue.enqueue(stack.pop());{
								
							}
							
						
					}break;
				}
			}
		  }
		
		//System.out.print(stack.toString());
		if(stack.isEmpty())
			throw new InvalidNotationFormatException();
		else if(stack.size()==1 && !((String)stack.top()).equals("("))
			throw new InvalidNotationFormatException();
		else if(stack.size() > 1)
			throw new InvalidNotationFormatException();
		else
			stack.pop();
		
		//System.out.print("\n postFix-> "+postFixSolutionQueue.toString() + "\n");
	
		return postFixSolutionQueue.toString();
	}
	
	
	/**converts postfix notation to infix notation that will take in a string 
	 * and returns a string.
	 * @param A String representation of a postfix expression.
	 * @return A String representation of the infix form.
	 * @throws InvalidNotationFormatException if stack content at the end is incorrect.
	 * */
	public static String convertPostfixToInfix(String s) {
		MyStack<String> operandStack = new MyStack<String>(s.length());
		
		
		for(int i=0; i < s.length(); i++) {
			if(!isAnOperator(s.charAt(i)))
				operandStack.push(Character.toString(s.charAt(i)));
			else {
				if(operandStack.size() > 1)
					operandStack.push(setUpInBrackets((String)operandStack.pop(), 
						(String)operandStack.pop(), s.charAt(i)));
				else 
					operandStack.push(Character.toString(s.charAt(i)));		
				
			}
			
		}
		//System.out.print(operandStack.toString());
		if(operandStack.size() > 1)
			throw new InvalidNotationFormatException();
		
		return (String)operandStack.pop();
	}
	/*evaluates the postfix expression. It will take in a string 
	 * and returns a double.
	 * @param A String representation of an infix expression
	 * @return the result as a double.
	 * **/
	
	public static double evaluatePostfixExpression(String s) {
		//MyQueue operandQueue = new MyQueue<String>(s.length());
		MyStack<String> operandStack = new MyStack<String>(s.length());
		
		
		for(int i=0; i < s.length(); i++) {
			if(!isAnOperator(s.charAt(i)))
				operandStack.push(Character.toString(s.charAt(i)));
			else {
				operandStack.push(operate((String)operandStack.pop(), 
						(String)operandStack.pop(), s.charAt(i)));
			}
		}
		
		
		
		return Double.parseDouble((String)operandStack.pop());
		
		
	}/**
	*Operates on 2 numbers. Given 2 numbers and an operator, it computes the result.
	*@param A String number "a", a String number "b" and a char operator 'o'
	*@return the result as a double.
	*/
	public static String operate(String a, String b, char o) {
		String stringResult="fail";
		double num2 = Double.parseDouble(a);
		double num1 = Double.parseDouble(b);
		char op  = o; 
		
		switch(op){
			case '-': stringResult = Double.toString(num1 - num2);break;
			case '+': stringResult = Double.toString(num1 + num2);break;
			case '*': stringResult = Double.toString(num1 * num2);break;
			case '/': stringResult = Double.toString(num1 / num2);break;
			
		}
		
		return stringResult;
	}
	/**Given 2 numbers or expressions as String. It sets them up
	 * in (a+b) form between brackets. Inverts order due to stack order,
	 * @param A String "a", a String "b" and an operator char 'c'.
	 * @return A String representation in "(a+b)" form.
	 * */
	public static String setUpInBrackets(String a, String b, char o) {
		
		return "(" + b + Character.toString(o) + a + ")";
	}
	
	
	
	/**returns a number to compare operator precedence 
	 * @param a char operator 'o' evaluate.
	 * @return a number that represents precedence*/
	public static int operatorPrecedence(char o) {
		
		
		if (o == '+' || o == '-')
			return 1;
		else 
			return 2;
	}
	/**Given a char 'c', it returns true if this is an operator, 
	 * false otherwise.
	 * @param A char operator 'c'.
	 * @return A boolean expression.
	 * */
	public static boolean isAnOperator(char c) {
		
		
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/': return true;
			
		default: return false;
		}
		
	}
	
	
	
	
	
	
	
}
