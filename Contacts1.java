import java.util.*;
public class Contacts1
{
	public static void main(String args[])
	{
		Contacts1 a=new Contacts1();
		Contacts1 b=new Contacts1();
		Contacts1 c=new Contacts1();
		HashSet hs=new HashSet();
		hs.add(a);
		hs.add(b);
		hs.add(c);
		hs.add("this is string object");
		hs.add(new Integer(4));
		Iterator i=hs.iterator();
		while(i.hasNext())
		{	
			System.out.println(i.next());
		}
	}



}