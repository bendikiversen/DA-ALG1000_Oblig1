public class SingleLinkedList
{
	private Node head;
	private int elementCount;

	SingleLinkedList()
	{
		head = null;
		elementCount = 0;
	}

	SingleLinkedList(Node head, int elementCount)
	{
		this.head = head;
		this.elementCount = elementCount;
	}
}
