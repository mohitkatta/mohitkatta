import java.util.*;
class Max
{

	
	public float max(float a,int b)
	{
		if(a>b)
		{
			System.out.println("a value displayed"+a);
			return a;
		}
		else
		{
			System.out.println("b value displayed"+b);
			return b;	
		}
		
	}
	public float max(int a,float b)
	{
		if(a>b)
		{
			System.out.println("a value displayed"+a);
		return a;
		}
		else
		{
			System.out.println("b value displayed"+b);	
			return b;
		}
		
	}
	public double max(double a,double b)
	{
		if(a>b)
		{
			System.out.println("a value displayed"+a);
			return a;
		}
		else
		{
			System.out.println("b value displayed"+b);
			return b;	
		}
		
	}
		
	public static void main(String[] args)
	{
		
		Max m=new Max();
		System.out.println(m.max(20.5f,10));
		System.out.println(m.max(5.5f,10.5f));
		System.out.println(m.max(10.4,5.5));
		

		
		
	}
}