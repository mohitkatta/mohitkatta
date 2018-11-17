import java.util.*;
public class Contacts
{
	public static void main(String args[])
	{
		Contacts a=new Contacts();
		Contacts b=new Contacts();
		Contacts c=new Contacts();
		HashSet<Contacts> hs=new HashSet<Contacts>();
		hs.add(a);
		hs.add(b);
		hs.add(c);
		Iterator i=hs.iterator();
		while(i.hasNext())
		{	
			System.out.println(i.next());
		}
	}



}