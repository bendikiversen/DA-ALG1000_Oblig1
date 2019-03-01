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
			if(head.value == target) //If target is the first node
			{
				head = head.next;
				elementCount--;
				return true;
			}
			else if(head.next == null) //If list only contains mismatching head
				return false;
			else
			{
				Node cPtr = head;
				while(cPtr.next.value != target && cPtr.next != null) //Iterate to target
					cPtr = cPtr.next;

				if(cPtr.next.value == target) //If target is in list, with more nodes following
				{
					cPtr.next = cPtr.next.next;
					elementCount--;
					return true;
				}
				else if(cPtr.value == target && cPtr.next == null) //Target is in last node
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
			Node placeholder = new Node(0, head); //Take out head to another temp. list.
			Node cPtr = placeholder;
			int origCount = elementCount;

			while(cPtr.next != null)
			{
				if(cPtr.next.value == target) //Remove target and decrease count
				{
					cPtr.next = cPtr.next.next;
					elementCount--;
				}
				else
					cPtr = cPtr.next;
			}
			head = placeholder.next;
			placeholder = null;

			if(origCount!=elementCount)
				return true;
			else
				return false;
		}
		return false;
	}

	void addFirst(int value) //5: Add node with value to beginning of list
	{
		if(head == null)	//If the list has no head node, create it
			head = new Node(value, null);
		else				//If the list has a head node, replace it
			head = new Node(value, head);
		elementCount++; //Increase element count by one
	}

	void addLast(int value) //6: Add node with value to end of list
	{
		if(head == null) //If the list has no head node, that is the end
		{
			head = new Node(value, null);
			elementCount++;
		}
		else
		{
			Node cPtr = head;
			while(cPtr.next != null)
				cPtr = cPtr.next;
			cPtr.next = new Node(value, null); //Create node after last node
			elementCount++;
		}
	}

	boolean addAfter(int target, int value) //7: Add node after given first occ. of given value
	{
		if(head != null)
		{
			if(head.value == target) //If target is the first node
			{
				head.next = new Node(value, head.next);
				elementCount++;
				return true;
			}
			else if(head.next == null) //If list only contains mismatching head
				return false;
			else
			{
				Node cPtr = head;
				while(cPtr.next.value != target && cPtr.next != null) //Iterate to target
					cPtr = cPtr.next;

				if(cPtr.next.value == target) //If target is in list, with more nodes following
				{
					cPtr.next.next = new Node(value,cPtr.next);
					elementCount++;
					return true;
				}
				else if(cPtr.value == target && cPtr.next == null) //Target is in last node
				{
					cPtr.next = new Node(value, null);
					elementCount++;
					return true;
				}
			}
		}
		return false;
	}

	boolean addBefore(int target, int value) //8: Add node before given first occ. of given value
	{
		if(head != null)
		{
			if(head.value == target) //If target is the first node
			{
				head = new Node(value, head);
				elementCount++;
				return true;
			}
			else if(head.next == null) //If list only contains mismatching head
				return false;
			else
			{
				Node cPtr = head;
				while(cPtr.next.value != target)
					cPtr = cPtr.next;

				if(cPtr.next.value == target)
				{
					cPtr.next = new Node(value, cPtr.next);
					elementCount++;
					return true;
				}
			}
		}
		return false;
	}

	int getLength() //9: Print list length
	{
		return elementCount;
	}

	boolean checkCount() //10: Check number of nodes vs variable elementCount
	{
		int counter = 0;
		if(head!=null)
		{

			Node cPtr = head;
			counter = 1;
			while(cPtr.next != null)
			{
				counter++;
				cPtr = cPtr.next;
			}
		}
		return counter==elementCount;
	}

	int numOfTarget(int target) //11: Count occurences of given value
	{
		int num = 0;
		if(head != null)
		{
		Node cPtr = head;
			if(head.value == target)
				num++;
			while(cPtr.next != null)
			{
				if(cPtr.value == target)
					num++;
				cPtr = cPtr.next;
			}
		}
		return num;
	}

	int[] toArray() //12: Print list values, 5 elements per line. Creates an returnable array.
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

	int clear() //13: Remove all list elements. Print number of deleted elements
	{
		int oldElementCount = elementCount;
		head = null;
		elementCount = 0;
		return oldElementCount;
	}

	Integer max() //14: Return the largest number
	{
		if(head != null)
		{
			int temp = head.value;
			Node cPtr = head;

			while(cPtr.next != null)
			{
				if(cPtr.value > temp)
					temp = cPtr.value;
				cPtr = cPtr.next;
			}
			return temp;
		}
		return null;
	}

	Integer min() //15: Return the smallest number
	{
		if(head != null)
		{
			int temp = head.value;
			Node cPtr = head;

			while(cPtr.next != null)
			{
				if(cPtr.value < temp)
					temp = cPtr.value;
				cPtr = cPtr.next;
			}
			return temp;
		}
		return null;
	}
}
