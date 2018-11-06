import java.util.*;
class Calculator
{

	public int c;
	public int s;
	public void add(int a,int b)
	{
		c=a+b;
		System.out.println("addition"+c);
	}
	public void sub(int a,int b)
	{
		c=a-b;
		System.out.println("substraction"+c);
	}
	public void mul(int a,int b)
	{
		c=a*b;
		System.out.println("multiplication"+c);
	}
	public void div(int a,int b)
	{
		if(b!=0)
		{
		c=a/b;
		
		System.out.println("division"+c);
		}
	}
	public void switchdisplay()
	{
		Scanner sc=new Scanner(System.in);
		
		do
		{
		System.out.println("Menu \n 1.Addition \n 2.Subtraction \n 3.multiplication \n 4. division");
		System.out.println("enter choice");
		s=sc.nextInt();
		System.out.println("enter a");
		int a=sc.nextInt();
		System.out.println("enter b");
		int b=sc.nextInt();
		switch(s)
		{
		case 1:
		add(a,b);
		break;
		case 2:	
		sub(a,b);
		break;
		case 3:
		mul(a,b);
		break;
		case 4:
		div(a,b);
		break;
		default:
		System.out.println("....not possible....");
		break;
		}
		
		}while(s<4);
		System.out.println("incorrerct choice");
		
		


	}



	public static void main(String[] args)
	{
	
		
		Calculator c1=new Calculator();

		
		
		c1.switchdisplay();
		
		
		
		
	}
}