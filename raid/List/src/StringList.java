public class StringList {
	
	private StringNode firstNode;
	
	StringList() {				// empty StringList
		firstNode = null;
	}

	StringList(String input) {	// actuall create a list
		firstNode = new StringNode(input);
	}

	StringList(int count) {		// test the list
		if(count > 0){
			firstNode = new StringNode("1");
			for(int i=0; i<count; i++){
				this.addEnd(String.valueOf(i));
			}
		}
	}

	/**
	 * fuegt einen neuen String hinten an
	 */
	void addEnd(String toAppend){
		StringNode current = firstNode;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new StringNode(toAppend);
	}
	
	/**
	 * fuegt einen neuen String in der Liste vorne an
	 */
	void addFront(String toAppend){
		StringNode tmp = firstNode;
		firstNode = new StringNode(tmp,toAppend);
	}

	/**
	 * gibt die Laenge der Liste zurueck
	 */
	int length() {
		StringNode current = firstNode;
		int length = 0;
		while(current.next != null) {
			current = current.next;
			length++;
		}
		return length;
	}

	/**
	 * loescht das erste Element in der Liste, dass String gleicht
	 */
	void del(String toDel){
		StringNode current = firstNode;
		while(current.next.content != toDel) {
			current = current.next;
			if (current.next == null){
				break;
			}
		}
		if(current.next.content == toDel) {
			current.next = current.next.next;
		}
	}

	/**
	 * loescht alle Elemente in der Liste, die String gleichen
	 */
	void delAll(String toDelAll){}
	
	/**
	 * löscht das erste Element der Liste
	 */
	void delFirst(){
		firstNode = firstNode.next;
	}
	
	/**
	 * löscht das letzte Element der Liste
	 */
	void delLast(){
		StringNode current = firstNode;
		while(current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}

	/**
	 * gibt den String aus der Liste zurueck, der mit String anfaengt
	 */
	String getPrefix(String searchfor){
		StringNode current = firstNode;
		while( !current.content.contains(searchfor) ) {
			current = current.next;
		}
		return searchfor;
	}
	
	/**
	 * gibt den n. String der Liste aus, falls der String nicht gefunden wird, gib null zurueck
	 */
	String getNth(int goalPos){
		if( goalPos <= 0 || goalPos > this.length() ) {
			return null;
		} else {
			StringNode current = firstNode;
			int curPos = 0;
			while(curPos < goalPos) {
				current = current.next;
				curPos++;
			}
			return current.content;
		}
	}
	
	/**
	 * gibt den n. String der Liste aus, falls der String nicht gefunden wird, gib String zurueck
	 */
	String getNthOr(int goalPos, String ifNotFound){
		if( goalPos <= 0 || goalPos > this.length() ) {
			return ifNotFound;
		} else { 
			StringNode current = firstNode;
			int curPos = 0;
			while(curPos < goalPos) {
				current = current.next;
				curPos++;
			}
			return current.content;
		}
	}

}

