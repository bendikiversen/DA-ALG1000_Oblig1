public class SingleLinkedList
{
	private Node head;
	private int elementCount;

	//Constructor for new SingleLinkedList
	SingleLinkedList()
	{
		head = null;
		elementCount = 0;
	}

	Node getHead()
	{
		return head;
	}

	int getLength()
	{
		return elementCount;
	}

	boolean removeFirst() //1
	{
		if(head != null)
		{
			if(head.next == null)
				head = null;
			else
				head = head.next;
			elementCount--;
			return true;
		}
		return false;
	}

	void appendFirst(int value) //5
	{
		if(head == null)
			head = new Node(value, null);
		else
			head = new Node(value, head);
		elementCount++;
	}

	int[] getList()
	{
		int[] list = new int[elementCount];
		Node cPtr = head;
		for(int i = 0; i < elementCount; i++)
		{
			list[i] = cPtr.value;
			cPtr = cPtr.next;
		}
		return list;
	}

	int initList()
	{
		int oldElementCount = elementCount;
		head = null;
		elementCount = 0;
		return oldElementCount;
	}
}
