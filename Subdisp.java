import java.util.*;
class Maindisp
{
	int rollno;
	String name;

	public Maindisp()
	{
		rollno=123;
		name="xyz";
	}
	public void mdisp()
	{
		System.out.println("rollno="+rollno);
		System.out.println("name="+name);
	}


}


//subclass
class Subdisp extends Maindisp
{
char sec;
	public Subdisp()
	{
		 
		sec='a';
	
	}
	
	public void sdisp()
	{
		mdisp();
		System.out.println("sec="+sec);
	}

	public static void main(String[] args)
	{
	Subdisp s=new Subdisp();
	s.sdisp();
	}
}


