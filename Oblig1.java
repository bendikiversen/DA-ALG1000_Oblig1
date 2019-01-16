import java.util.Scanner;

public class Oblig1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int option;

		System.out.println("SingleLinkedList Program\n");

		SingleLinkedList myList = new SingleLinkedList();
		myList.appendFirst(3);
		myList.appendFirst(2);
		myList.appendFirst(1);
		myList.removeFirst();
		myList.appendFirst(4);
		System.out.println("Length: " + myList.getLength()+"\n");

		Node cPtr = myList.getHead();

		//Debug for printing av liste
		for(int i = 0; i<myList.getLength(); i++)
		{
			System.out.println(cPtr + ": " + cPtr.value);
			cPtr = cPtr.next;
		}

		System.out.println(java.util.Arrays.toString(myList.getList()));
		System.out.println(java.util.Arrays.toString(myList.getList()));

		/* do
		{
			System.out.println("1:\tDelete first element.\n"
			+ "5:\tAppend element with value at start of list.\n"
			+ "9:\tPrint length of list.\n"
			+ "12:\tPrint list contents. 5 elements per line.\n"
			+ "13:\tErase list. Prints number of deleted elements.\n");
			System.out.print("Select option: ");
			option = input.nextInt();
			System.out.println();

			switch(option)
			{
				case 1:
					System.out.println("Option 1 selected.\n");
					break;
				case 5:
					System.out.println("Option 5 selected.\n");
					break;
				case 9:
					System.out.println("Option 9 selected.\n");
					break;
				case 12:
					System.out.println("Option 12 selected.\n");
					break;
				case 13:
					System.out.println("Option 13 selected.\n");
					break;
				case 0:
					System.out.println("Option 0 selected, program stops.\n");
					break;
				default:
					System.out.println("Invalid option.\n");
					break;
			}

		} while(option != 0);
		*/

	}
}