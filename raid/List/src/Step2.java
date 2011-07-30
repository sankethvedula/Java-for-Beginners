public class Step2 {
	
	public static void main(String bla[]) {
		long before = System.currentTimeMillis();
		StringList mylist = new StringList(1000000);
		long after = System.currentTimeMillis();
		long diff = after - before;
		System.out.println("Creation of List took " + diff + " milliseconds");
		
		System.out.println("length: "			+ mylist.length());
		System.out.println("evaluated length: "	+ mylist.evaluateLength());
		
		System.out.println("adding another 1000000 elements to the list...");
		before = System.currentTimeMillis();
		for(int i=0; i<1000000; i++)
			mylist.addEnd(String.valueOf(1000000+i));
		System.out.println("done");
		after = System.currentTimeMillis();
		diff = after - before;
		System.out.println("appending took " + diff + " milliseconds");
		
		for(int elem=0; elem<2000001; elem+=500000) {
			System.out.println("\n--- now looking for element #" + elem);
			before = System.currentTimeMillis();
			System.out.println("content of element #" + elem + ": \"" + mylist.getNth(500000) + "\"");
			after = System.currentTimeMillis();
			diff = after - before;
			System.out.println("looking for element #" + elem + " took " + diff + " milliseconds");
		}
		
	}
	
	// Schreibt ein Programm, dass die Zeit ausliest und dann auf einer kurzen
	// oder sehr langen Liste ein (oder mehrere, wenn die Zeit sonst zu kurz
	// ist) Element hinzufügt, bzw. das letzte Element der Liste mit getNth aus
	// liest.
	
}
