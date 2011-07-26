public class List {

	public static void main(String bla[]) {

		long before = System.currentTimeMillis();			// System.out.println("before: " + before);
		StringList mylist = new StringList(1000000);
		long after = System.currentTimeMillis();			// System.out.println("after: " + after);
		long diff = after - before;
		System.out.println("Creation of List took " + diff + " milliseconds");
		
		System.out.println(mylist.length());
		System.out.println(mylist.evaluateLength());
//		System.out.println(mylist.print());

	}

}
