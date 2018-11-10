//final variables

 class Shape 
{
	public final double dim1=10.102;
	public final double dim2=20.102;

	
	public double area()
	{
		return 0.0;
	}
}


 class Rectangle extends Shape 
{	

	
	public double area() 
	{
		return dim1*dim2;
	}

}


public class fvar
{

	public static void main(String arg[])
	{
		Rectangle obj=new Rectangle();
		
		System.out.println("Area of Rectangle:"+obj.area());
	}
}
