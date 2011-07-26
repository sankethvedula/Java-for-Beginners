public class StringNode {
	
	private StringNode next;
	private String content;

	StringNode(StringNode next, String content){
		this.next = next;
		this.content = content;
	}
	StringNode(String content){							// end of list
		this.next = null;
		this.content = content;
	}

	public StringNode getNext() {
		return next;
	}
	public void setNext(StringNode next) {
		this.next = next;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
