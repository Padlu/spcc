import java.util.*;
import java.util.Stack;
 
public class TestQuad 
{ 
	static void evaluatePostfix(String exp)
	{
		Stack<String> stack = new Stack<>();
		int i,k = 0;
		String c,ch;
		char comp;	
		
		for(i=0;i<exp.length();i++)
		{
			comp = exp.charAt(i);
			c = Character.toString(comp);
			
			if(comp == '+' || comp == '-' || comp == '*' || comp == '/')
				{
					k++;
					String val1 = stack.pop();
					String val2 = stack.pop();
					ch = ("T" + k);
					stack.push(ch);
					System.out.println(c+"\t"+val2+"\t"+val1+"\tT"+k);
				}
			else
				stack.push(c);
		}    
	}
	 
	// Driver program to test above functions
	public static void main(String[] args) 
	{
		String exp="AB+C*DE-FG+*-"; // (((A+B)*C)-((D-E)*(F+G)))
		System.out.println("The Postfix expression provided is : " + exp + "\n\nThe Quadruple Table for above postfix expression :");
		System.out.println("\nOP\tVAR1\tVAR2\tRES");
		evaluatePostfix(exp);
	}
}
