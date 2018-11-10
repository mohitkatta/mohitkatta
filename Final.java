//final method

public class Final
{
	public  final int a=10;
	public  final int b=90;
	
	 final void display(int a,int b2)
	{
	
		System.out.println("..."+this.a+"..."+this.b);
	}
}
	class Sub extends Final
	{
		void display(int a,int b2)
		{
	
			System.out.println("..."+this.a+"..."+this.b);
		}
		public static void main(String arg[])
		{
		
		
			Sub s=new Sub();
			s.display(5,4);
		}
	
	}