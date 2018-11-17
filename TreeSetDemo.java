import java.util.Iterator;
import java.util.TreeSet;
public class TreeSetDemo
{
	public static void main(String args[])
	{
		TreeSet<Integer> obj=new TreeSet<Integer>();
		Integer ob1=new Integer(4);
		Integer ob2=new Integer(1);
		Integer ob3=new Integer(3);
		Integer ob4=new Integer(2);
		System.out.println("Size of treeset is:"+obj.size());
		obj.add(ob1);
		obj.add(ob2);
		obj.add(ob3);
		obj.add(ob4);
		System.out.println("\ntreeset after adding objects:"+obj);
		System.out.println("\n size oftreeset after adding objects:"+obj.size());
		System.out.println("\nfinal treeset");
		Iterator i=obj.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

		
	}
}