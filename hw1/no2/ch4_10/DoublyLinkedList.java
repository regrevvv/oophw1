package hw1.no2.ch4_10;
class Node{
	String nodeData;
	Node leftNode = null;
	Node rightNode = null;
	public Node(String nodeData, Node leftNode, Node rightNode) {
		this.nodeData = nodeData;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}
public class DoublyLinkedList {
	Node listHead;
	Node listTail;
	
	public DoublyLinkedList() {
		listHead = null;
		listTail = null;
	}
	//새 data 노드에 삽입
	public void insertNode(String data) {
		Node inNode = new Node(data, null, null);
		if(this.listHead == null) {
			this.listHead = inNode;
		}
		else {
			inNode.leftNode = this.listTail;
			listTail.rightNode = inNode;
		}
		this.listTail = inNode;
	}
	//이중링크드리스트 순서대로 출력
	public void displayDoublyLinkedList() {
		if(this.listHead == null)
		{
			System.err.println("List is empty!");
			return;
		}
		for(Node currentNode = this.listHead; currentNode.rightNode != null; currentNode = currentNode.rightNode) {
			System.out.print(currentNode.nodeData + " ");
		}
		System.out.println('\n');
	}
	//data 값으로 노드 삭제
	public void removeNode(String data) {
		Node remove = null;//삭제할 노드
		Node before = null;//삭제할 노드의 이전 노드
		Node after = null;//삭제할 노드의 이후 노드
		for(remove = this.listHead; remove != null;before = remove, after = remove.rightNode.rightNode, remove = remove.rightNode) {
			if(remove.nodeData == data)
			{
				if(remove == this.listHead) {//첫 노드 삭제
					if(this.listHead == this.listTail)//단일 노드 링크드리스트 경우
						this.listTail = null;
					this.listHead = this.listHead.rightNode;
					this.listHead.leftNode = null;
					return;
				}
				if(remove == this.listTail) {//마지막 노드 삭제
					before.rightNode = null;
					this.listTail = before;
					return;
				}
				before.rightNode = after;
				after.leftNode = before;
				return;
			}
		}
	}
}
