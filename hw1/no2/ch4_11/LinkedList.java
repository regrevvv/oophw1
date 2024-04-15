package hw1.no2.ch4_11;
class Node{
	String nodeData;
	Node nextNode = null;
	public Node(String nodeData, Node nextNode) {
		this.nodeData = nodeData;
		this.nextNode = nextNode;
	}
}
public class LinkedList {
	Node listHead;
	Node listTail;
	
	public LinkedList() {
		listHead = null;
		listTail = null;
	}
}
