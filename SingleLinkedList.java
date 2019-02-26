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
		if(elementCount > 0) //Check that the list has a head
		{
			head = head.next; //Sets head to the next node
			elementCount--; //Element count decreases by one
			return true; //Operation successful
		}
		return false; //Operation failed (empty list)
	}

	boolean removeLast() //2: Remove last element in list
	{
		if(elementCount > 0) //Check that the list has a head
		{
			if(head.next == null) //No following node after head
			{
				head = null; //Removes head node
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

	boolean removeFirstOccurrence(int target) //3: remove first occurrence of given value
	{
		if(head != null)
		{
			if(head.value == target)
			{
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

	boolean removeAll(int target) //4: Remove all occurrences of given value
	{
		if(elementCount > 0)
		{
			Node placeholder = new Node(0, head);
			Node cPtr = placeholder;
			int origCount = elementCount;

			while(cPtr.next != null)
			{
				if(cPtr.next.value == target)
				{
					cPtr.next = cPtr.next.next;
					elementCount--;
				}
				else
					cPtr = cPtr.next;
			}
			head = placeholder.next;

			if(origCount!=elementCount)
				return true;
			else
				return false;
		}
		return false;
	}

	void addFirst(int value) //5: Append node with value to beginning of list
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
