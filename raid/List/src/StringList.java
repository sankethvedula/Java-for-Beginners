public class StringList {
	
	private StringNode begin, end;
	private int length;
	
	StringList() {				// empty StringList
		begin = end = null;
		length = 0;
	}

	StringList(String input) {	// actually create a list
		begin = end = new StringNode(input);
		length = 1;
	}

	StringList(int count) {		// test the list
		if(count > 0) {
			begin = end = new StringNode("1");
			length = 1;
			for(int i=2; i <= count; i++) {
				this.addEnd(String.valueOf(i));
			}
		}
	}

	/**
	 * fuegt einen neuen String in der Liste vorne an
	 */
	void addFront(String toAdd) {
		if( length == 0 ) {
			length++;
			begin = new StringNode(toAdd);
			end = findLastNode();
		} else {
			length++;
			StringNode tmp = begin;
			begin = new StringNode(tmp,toAdd);
		}
	}

	/**
	 * fuegt einen neuen String hinten an
	 */
	void addEnd(String toAdd) {
		if( length == 0 ) {
			length++;
			begin = new StringNode(toAdd);
			end = findLastNode();
		} else if( length == 1 ) {
			length++;
			begin.setNext(end);
			end.setNext(new StringNode(toAdd));
			end = end.getNext();
		} else {
			length++;
			end.setNext(new StringNode(toAdd));
			end = end.getNext();
//			end = findLastNode();
		}
	}

	/**
	 * gibt die Laenge der Liste zurueck
	 */
	int length() {
		return length;
	}

	/**
	 * evaluiert die länge der liste neu
	 */
	int evaluateLength() {
		if(begin.getNext() == null) {
			return 0;
		} else {
			StringNode current = begin;
			int tmplength = 1;
			while(current.getNext() != null) {
				current = current.getNext();
				tmplength++;
			}
			return tmplength;
		}
	}
	
	/**
	 * loescht das erste Element in der Liste, dass String gleicht
	 */
	void del(String toDel) {
		StringNode current = begin;
		while(current.getNext().getContent() != toDel) {
			current = current.getNext();
			if (current.getNext() == null) {	// ende?
				break;
			}
			if(current.getNext().getContent() == toDel) {
				current.setNext( current.getNext().getNext() );
				break;
			}
		}
	}

	/**
	 * loescht alle Elemente in der Liste, die String gleichen
	 */
	void delAll(String toDel) {
		StringNode current = begin;
		while(current.getNext().getContent() != toDel) {
			current = current.getNext();
			if (current.getNext() == null) {	// ende?
				break;
			}
			if(current.getNext().getContent() == toDel) {
				current.setNext( current.getNext().getNext() );
				// hier kein break
			}
		}
	}
	
	/**
	 * löscht das erste Element der Liste
	 */
	void delFirst() {
		if(length > 0) {
			length--;
			begin = begin.getNext();			
		}
	}
	
	/**
	 * löscht das letzte Element der Liste
	 */
	void delLast() {
		if(length > 0) {
			length--;
			StringNode current = begin;
			while(current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
		}
	}

	/**
	 * gibt den String aus der Liste zurueck, der mit String anfaengt
	 */
	String getPrefix(String searchfor) {
		StringNode current = begin;
		while( !current.getContent().contains(searchfor) ) {
			current = current.getNext();
		}
		return searchfor;
	}
	
	/**
	 * gibt den n. String der Liste aus, falls der String nicht gefunden wird, gib null zurueck
	 */
	String getNth(int goalPos) {
		if( goalPos < 1 || goalPos > this.length() ) {
			return null;
		} else {
			StringNode current = begin;
			int curPos = 1;
			while(curPos < goalPos) {
				current = current.getNext();
				curPos++;
			}
			return current.getContent();
		}
	}
	
	/**
	 * gibt den n. String der Liste aus, falls der String nicht gefunden wird, gib String zurueck
	 */
	String getNthOr(int goalPos, String ifNotFound) {
		if( goalPos < 1 || goalPos > this.length() ) {
			return ifNotFound;
		} else {
			StringNode current = begin;
			int curPos = 1;
			while(curPos < goalPos) {
				current = current.getNext();
				curPos++;
			}
			return current.getContent();
		}
	}
	
	String print() {
		StringNode current = begin;
		String out = "";
		int pos = 1;
		while(current.getNext() != null) {
			out = out + pos + ": " + current.getContent() + "\n";
			pos++;
			current = current.getNext();
		}
		return out;
	}
	
	StringNode findLastNode() {
		StringNode current = begin;
		while(current.getNext() != null)
			current = current.getNext();
		return current;
	}
	
	boolean isEmpty() {
		if(begin == null)
			return true;	// tut das?
		return false;
	}
	
}

