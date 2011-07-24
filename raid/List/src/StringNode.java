public class StringNode {
	
	public StringNode next;
	public String content;

	StringNode(StringNode next, String content){
		this.next = next;
		this.content = content;
	}
	StringNode(String content){							// end of list
		this.next = null;
		this.content = content;
	}

}
