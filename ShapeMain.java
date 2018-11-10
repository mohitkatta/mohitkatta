 class Shape 
{
	double dim1,dim2;
	
	public Shape(double d1,double d2)
	{
		dim1=d1;
		dim2=d2;
	}
	
	public double area()
	{
		return 0.0;
	}
}


 class Rectangle extends Shape 
{	
	public Rectangle(double d1,double d2)
	{
		super(d1,d2);
	}
	
	public double area() 
	{
		return dim1*dim2;
	}

}


public class ShapeMain
{

	public static void main(String arg[])
	{
		Rectangle obj=new Rectangle(10,20);
		
		System.out.println("Area of Rectangle:"+obj.area());
	}
}

