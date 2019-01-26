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

	//Returns address of head (first node in list)
	Node getHead()
	{
		return head;
	}

	boolean removeFirst() //1: Remove first element in list
	{
		if(head != null) //Check that the list has a head
		{
			if(head.next == null)	//No following node after head
				head = null;
			else					//Head node has a following node
				head = head.next;
			elementCount--; //Element count decreases by one
			return true; //Operation successful
		}
		return false; //Operation failed (empty list)
	}

	boolean removeLast() //2: Remove last element in list
	{
		if(elementCount > 0)
		{
			if(head.next == null)
			{
				head = null;
			}
			else
			{
				Node cPtr = head;
				while(cPtr.next != null)
				{
					cPtr = cPtr.next;
				}
				cPtr = null;
			}
			elementCount--;
			return true;
		}
		return false;
	}

	boolean removeFirstValue(int target) //3: remove first occurrence of given value
	{
		if(head != null)
		{
			if(head.value == target)
			{
				if(head.next == null)
					head = null;
				else
					head = head.next;

				elementCount--;
				return true;
			}
			else if(head.next == null)
				return false;
			else
			{
				Node cPtr = head;
				while(cPtr.next.value != target && cPtr.next != null)
					cPtr = cPtr.next;

				if(cPtr.next.value == target)
				{
					cPtr.next = cPtr.next.next;
					elementCount--;
					return true;
				}
				else if(cPtr.value == target && cPtr.next == null)
				{
					cPtr = null;
					elementCount--;
					return true;
				}
			}
		}
		return false;
	}

	void insertFirst(int value) //5: Append node with value to beginning of list
	{
		if(head == null)	//If the list has no head node, create it
			head = new Node(value, null);
		else				//If the list has a head node, replace it
			head = new Node(value, head);
		elementCount++; //Increase element count by one
	}

	int getLength() //9: Print list length
	{
		return elementCount;
	}

	int[] getList() //12: Print list values, 5 elements per line
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

	int initList() //13: Remove all list elements. Print number of deleted elements
	{
		int oldElementCount = elementCount;
		head = null;
		elementCount = 0;
		return oldElementCount;
	}
}
