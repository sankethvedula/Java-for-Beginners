public class List {

	public static void main(String bla[]) {
		StringList mylist = new StringList(1000);	
		System.out.println(mylist.length());
		System.out.println(mylist.evaluateLength());
//		System.out.println(mylist.print());

	}

	long benchmarkCreation(int count) {
		long before = System.currentTimeMillis();
		// System.out.println("before: " + before);
		StringList list = new StringList(count);
		long after = System.currentTimeMillis();
		// System.out.println("after: " + after);
		long diff = after - before;
//		System.out.println("Creation of List took " + diff + " milliseconds");
		return diff;
	}
	
	String find(StringList list, String term) {
		
		
		return "not yet";
	}
	
}
