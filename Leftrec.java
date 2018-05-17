import java.util.*;
class Leftrec{
	public static void main(String args[])
	{
		int n,i,index=0;
		System.out.println("Enter the number of productions : ");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		String prod[]=new String[n];
		System.out.println("Enter the productions : \n");
		for(i=0;i<prod.length;i++)
		{
			System.out.print("("+(i+1)+") ");
			prod[i]=sc.next();
		}
		for(i=0;i<n;i++)
		{
			char[] prodc=prod[i].toCharArray();
			if(prodc[0]==prodc[3])
			{
				System.out.println("The production ("+(i+1)+") is Left Recursive : ");
				int j;
				for(j=0;j<prodc.length;j++)
				{
					if(prodc[j]=='|')
						index=j;
				}
				String alpha = prod[i].substring(4,index);
				String beta = prod[i].substring(index+1,prod[i].length());
				System.out.println(prodc[0]+" -> "+beta+prodc[0]+"'");
				System.out.println(prodc[0]+"'"+" -> "+alpha+prodc[0]+"'"+"|"+"ϵ");
			}
			else
			{
				System.out.println("The production ("+(i+1)+") is not Left Recursive : ");
				System.out.println(prod[i]);
			}	
		}

	}
}
