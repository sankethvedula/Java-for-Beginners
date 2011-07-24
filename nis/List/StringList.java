/**
* @author Nis Meinert
*/
public class StringList {
	private int length;

	private Elem first, last;

	public StringList() {}

	
	public StringList(String value) {
		first = new Elem(value);
		last = first;
		length = 1;
	}


	public StringList(int length) {
		if(length>0) {
			first = new Elem("0");
			last = add(first, 1, length);
			this.length = length;
		}
	}



	public void addEnd(String value) {
		if(length==0) addFront(value);
		else {
			last.setNext(new Elem(value));
			last = last.getNext();
			length++;
		}
	}


	public void addFront(String value) {
		first = new Elem(first, value);
		length++;

		if(length==1) last = first;
	}


	public int length() {
		return length;
	}


	public boolean del(String value) {
		if(length==0) return false;

		if(first.getValue().equals(value)) {
			first = first.getNext();
			length--;
			return true;
		}
		
		Elem elem = first;
		while(elem.getNext()!=null) {
			if(elem.getNext().getValue().equals(value)) {
				elem.setNext(elem.getNext().getNext());
				length--;
				return true;
			}
			elem = elem.getNext();
		}
		return false;
	}


	public int delAll(String value) {
		if(length==0) return 0;
		
		int counter = 0;
		if(first.getValue().equals(value)) {
			first = first.getNext();
			counter++;
		}

		Elem elem = first;
		while(elem.getNext()!=null) {
			if(elem.getNext().getValue().equals(value)) {
				elem.setNext(elem.getNext().getNext());
				counter++;
			}
			elem = elem.getNext();
		}
		length-=counter;
		return counter;
	}


	public boolean delFirst() {
		if(length==0) return false;

		first = first.getNext();
		length--;

		if(length==1) last = first;
		return true;
	}


	public boolean delLast() {
		if(length==0) return false;
		if(length==1) {
			delFirst();
			return true;
		}

		last = getPrevLast(first);
		length--;
		return true;
	}


	public String getPrefix(String value) {
		if(length==0) return null;

		return getPrefix(value, first);
	}


	public String getNth(int n) {
		if(length<1 || n>length-1) return null;
		if(n==0) return first.getValue();
		if(n==length-1) return last.getValue();

		return get(first, 0, n).getValue();
	}


	public String getNthOr(int n, String rstring) {
		String value = getNth(n);
		if(value==null) return rstring;
		return value; 
	}

	
	private Elem add(Elem elem, int i, int n) {
		if(i==n) return elem;
		Elem newElem = new Elem("" + i);
		elem.setNext(newElem);
		return add(newElem, ++i, n);
	}
	

	private Elem getPrevLast(Elem elem) {
		if(elem.getNext().getNext()==null) return elem;

		return getPrevLast(elem.getNext());
	}


	private String getPrefix(String value, Elem elem) {
		if(elem.getValue().startsWith(value)) return elem.getValue();

		if(elem.getNext()==null) return null;

		return getPrefix(value, elem.getNext());
	}


	private Elem get(Elem elem, int i, int n) {
		if(i==n) return elem;
		return get(elem.getNext(), ++i, n);
	}
	

	private class Elem {
		private Elem next;
		private String value;

		public Elem(String value) {
			this.value = value;
		}

		public Elem(Elem next, String value) {
			this.next = next;
			this.value = value;
		}


		public Elem getNext() { return next; }
		public void setNext(Elem next) { this.next = next; }
		
		public String getValue() { return value; }
		public void setValue(String value) { this.value = value; }
	}
}
