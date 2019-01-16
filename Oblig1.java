import java.util.Scanner;

public class Oblig1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int option, data;

		System.out.println("SingleLinkedList Program, desc. here\n");

		SingleLinkedList myList = new SingleLinkedList();

		//Node cPtr = myList.getHead();

		//Debug for printing av liste
		/* for(int i = 0; i<myList.getLength(); i++)
		{
			System.out.println(cPtr + ": " + cPtr.value);
			cPtr = cPtr.next;
		}
		*/

		do
		{
			System.out.println("========================================================");
			System.out.println("1:\tDelete first element.\n"
			+ "5:\tAppend element with value at start of list.\n"
			+ "9:\tPrint length of list.\n"
			+ "12:\tPrint list contents. 5 elements per line.\n"
			+ "13:\tErase list. Prints number of deleted elements.\n"
			+ "0: Exit program\n");
			System.out.print("Select option: ");
			option = input.nextInt();

			switch(option)
			{
				case 1:
					if(myList.removeFirst())
						System.out.println("Removed first element\n");
					else
						System.out.println("No first element\n");
					break;
				case 5:
					System.out.print("Enter integer: ");
					data = input.nextInt();
					System.out.println();
					myList.appendFirst(data);
					System.out.println(data + " appended to the beginning of list\n");
					break;
				case 9:
					System.out.println("The list has length: " + myList.getLength()+"\n");
					break;
				case 12:
					System.out.println(java.util.Arrays.toString(myList.getList())+ "\n");
					break;
				case 13:
					System.out.println("Initialized list, removed " + myList.initList() + " elements.");
					break;
				case 0:
					System.out.println("Program stops.\n");
					break;
				default:
					System.out.println("Invalid option.\n");
					break;
			}
		} while(option != 0);
	}//End of main
}//End of Oblig1
