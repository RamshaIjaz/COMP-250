
/* NAME: RAMSHA IJAZ
 * ID: 260665762

 */

import java.util.Stack;
import java.util.ArrayList;

public class Expression  {
	private ArrayList<String> tokenList;

	//  Constructor    
	/**
	 * The constructor takes in an expression as a string
	 * and tokenizes it (breaks it up into meaningful units)
	 * These tokens are then stored in an array list 'tokenList'.
	 */

	Expression(String expressionString) throws IllegalArgumentException{
		tokenList = new ArrayList<String>();

		expressionString = expressionString.replaceAll("\\s", ""); // removes spaces from the string
		boolean isInt = false;

		/* builds the tokenList by iterating through the string and appending characters in token
	     the characters are then added as strings to the tokenList
		 */

		for(int i=0; i<expressionString.length(); i++) { 

			StringBuilder token = new StringBuilder();    

			if(expressionString.charAt(i) >='0' && expressionString.charAt(i) <= '9') { //checks for integers
				isInt = true;
				token.append(expressionString.charAt(i));
				while (isInt) {
					//checks whether next character is also an integer and appends it to the token

					if(expressionString.charAt(i+1) >='0' && expressionString.charAt(i+1) <= '9') {
						token.append(expressionString.charAt(i+1));									
						i++;																		
					}
					else {
						isInt = false;
					}
				}
				tokenList.add(token.toString());						//appends the integers as string in the tokenList

			}

			//checks for each operator and adds it to tokenList

			else if(expressionString.charAt(i) == '+') { //checks for increment operator
				if(i+1 < expressionString.length() && expressionString.charAt(i+1) == '+') {		
					tokenList.add("++");
					i++;
				}
				else {
					tokenList.add("+");
				}

			}
			else if(expressionString.charAt(i) == '-') {//checks for decrement operator 
				if(i+1 < expressionString.length() && expressionString.charAt(i+1) == '-') {
					tokenList.add("--");
					i++;
				}
				else {
					tokenList.add("-");
				}

			}
			else {
				token.append(expressionString.charAt(i)); //stores parenthesis
				tokenList.add(token.toString());
			}

		}


	}

	/**
	 * This method evaluates the expression and returns the value of the expression
	 * Evaluation is done using 2 stack ADTs, operatorStack to store operators
	 * and valueStack to store values and intermediate results.
	 * - You must fill in code to evaluate an expression using 2 stacks
	 */
	public Integer eval(){
		Stack<String> operatorStack = new Stack<String>();
		Stack<Integer> valueStack = new Stack<Integer>();

		//iterates through the tokenList in order to obtain the characters

		for (int j = 0; j < tokenList.size(); j++) { 
			String currToken = tokenList.get(j);
			if (currToken.equals("(") || currToken.equals("[")) { //ignores the opening parenthesis/brackets and moves to next character
				;
			} 
			//checks for operators and integers and pushes them in their respective stacks

			else if (currToken.equals("+") || currToken.equals("-") || currToken.equals("*")
					|| currToken.equals("/") || currToken.equals("++") || currToken.equals("--")) {
				operatorStack.push(currToken);
			} 
			else if (isInteger(currToken)) {
				valueStack.push(Integer.valueOf(currToken));
			} 

			/*checks for right parenthesis and pops out the operator from the operatorStack 
			as it marks the end of expression ==> operation has to be performed
			 */

			else if (currToken.equals(")")) {
				String op = operatorStack.pop();
				int a = 0;

				//evaluates for each operator and saves the answer back to valueStack for next expression or for evaluating the result

				if (op.equals("+")) {
					a = valueStack.pop() + valueStack.pop();
					valueStack.push(a);
				} 
				else if (op.equals("-")) {
					int b=valueStack.pop();
					a = valueStack.pop() - b;
					valueStack.push(a);
				} 
				else if (op.equals("*")) {
					a = valueStack.pop() * valueStack.pop();
					valueStack.push(a);
				} 
				else if (op.equals("/")) {
					int c=valueStack.pop();
					a = valueStack.pop() / c;
					valueStack.push(a);
				}
				else if(op.equals("++")) {
					a = valueStack.pop();
					++a;
					valueStack.push(a);
				}
				else if(op.equals("--")) {
					a = valueStack.pop();
					--a;
					valueStack.push(a);
				}


			}
			else if(currToken.equals("]")) {
				valueStack.push(Math.abs(valueStack.pop()));

			}

		}
		return valueStack.pop(); //returns the final answer after evaluating the expression
	}

	//Helper methods
	/**
	 * Helper method to test if a string is an integer
	 * Returns true for strings of integers like "456"
	 * and false for string of non-integers like "+"
	 * - DO NOT EDIT THIS METHOD
	 */
	private boolean isInteger(String element){
		try{
			Integer.valueOf(element);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}

	/**
	 * Method to help print out the expression stored as a list in tokenList.
	 * - DO NOT EDIT THIS METHOD    
	 */

	@Override
	public String toString(){	
		String s = new String(); 
		for (String t : tokenList )
			s = s + "~"+  t;
		return s;		
	}

}



