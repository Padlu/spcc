import java.util.*;

public class preparser{
	static char[] stack = new char[20];
	static int top;
	static ArrayList<Table> prods = new ArrayList<Table>(); 
	
	public static void main(String[] args){		
		top = -1;
		prods.add(new Table('A','a',"aX"));
		prods.add(new Table('X','b',"BBX"));
		prods.add(new Table('X','d',"BBX"));
		prods.add(new Table('X','$',"^"));
		prods.add(new Table('B','b',"bY"));
		prods.add(new Table('B','d',"dY"));
		prods.add(new Table('Y','b',"^"));
		prods.add(new Table('Y','c',"CY"));
		prods.add(new Table('Y','d',"^"));
		prods.add(new Table('Y','$',"^"));
		prods.add(new Table('C','c',"c"));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input to be checked");
		String input = sc.next();
		
		push('$');
		push('A');
	
		for(int i = 0; i < input.length();){
			char tsym = stack[top];
			boolean found = false;
			
			if(stack[top] == '$' && input.charAt(i) == '$'){
				System.out.println("String is derivable");
				break;
			}
			
			if(stack[top] == '^'){
				pop();
				continue;
			}
			
				
			for(int j = 0 ; j < prods.size(); j++){
				Table x = prods.get(j);
				if(x.getCol() == input.charAt(i) && x.getRow() == tsym){
					found = true;
					String result = x.getProd();
					pop();
					for(int k = result.length() - 1; k >= 0; k--){
						push(result.charAt(k));
					}
				}		
			}
			
			if(!found){
				System.out.println("String is not derivable");
				break;
			}
			
			if(stack[top] == input.charAt(i)){
				i++;
				pop();
			}
			
		}
							
	}
	
	static void pop(){
		top--;
	}
	
	static void push(char x){
		stack[++top] = x;
	}
}


class Table{
	char row;
	char col;
	String prod;
	
	Table(char row, char col, String result){
		this.row = row;
		this.col = col;
		prod = result;
	}
	
	public char getRow(){
		return row;
	}
	
	public char getCol(){
		return col;
	}
	
	public String getProd(){
		return prod;
	}
}
