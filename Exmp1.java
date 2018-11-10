//absttract class 

abstract class Exmp
{
	String var1="hi";
	String var2="this is mohit";
	public abstract void append(int var1,int var2);
}

public class Exmp1
{

	public void append(int var1,int var2)
	{
		System.out.println("append"+var1""+var2);
	}
	public static void main(String arg[])
	{
		Exmp1 e=new Exmp1();
		e.append(var1,var2);
	}

}
