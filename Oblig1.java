import java.util.Scanner;

public class Oblig1
{
	public static void main(String[] args)
	{
		//Declare variables for user interaction
		Scanner input = new Scanner(System.in);
		int option, data;

		//Greet user with program function
		System.out.println("Welcome to the SingleLinkedList Program!");

		//Create a new SingleLinkedList-object with its default constructor
		//Will create a linked list pointing to null (head), with 0 elements
		SingleLinkedList myList = new SingleLinkedList();

		printMenu();

		//Do-while loop for interactive menu,repeats till user-exit.
		do
		{
			//Print menu with options and input
			System.out.print("Select option: ");
			option = input.nextInt();

			switch(option)
			{
				case 1:
					if(myList.removeFirst())
						System.out.println("Removed first element.\n");
					else
						System.out.println("List is empty, cannot remove first element.\n");
					break;
				case 2:
					if(myList.removeLast())
						System.out.println("Removed last element.\n");
					else
						System.out.println("List is empty, cannot remove last element.\n");
					break;
				case 3:
					System.out.print("Enter integer remove (first occurrence): ");
					data = input.nextInt();
					if(myList.removeFirstValue(data))
						System.out.println("First occurrence of " + data + " removed.\n");
					else
						System.out.println(data + " was not found in the list\n");
					break;
				case 4:
					break;
				case 5:
					System.out.print("Enter integer to insert: ");
					data = input.nextInt();
					myList.insertFirst(data);
					System.out.println(data + " inserted to the beginning of list.\n");
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					System.out.println("The list has " + myList.getLength()+" elements.\n");
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					printArray(myList.getList());
					System.out.println();
					break;
				case 13:
					int old = myList.initList();
					System.out.println("Initialized list. Removed " + old + " elements.");
					break;
				case 14:
					break;
				case 15:
					break;
				case 100:
					printMenu();
					break;
				case 0:
					System.out.println("Program stops.\n");
					break;
				default:
					System.out.println("Non-existent option.\n");
					break;
			}
		} while(option != 0);
	}//End of main

	static void printArray(int[] array)
	{
		if(array.length != 0)
			for(int i=0; i<array.length; i++)
			{
				if(i%5==0)
					System.out.println();
				System.out.print(array[i] + " ");
			}
		else
			System.out.println("List is empty, nothing to print.");
	}//End of printArray

	static void printMenu()
	{
		System.out.println("========================================================");
					System.out.println("1:\tDelete first element in list.\n"
					+ "2:\tDelete last element in list.\n"
					+ "3:\tDelete first occurence of given value.\n"
					+ "5:\tInsert element with value at start of list.\n"
					+ "9:\tPrint length of list.\n"
					+ "12:\tPrint list contents, 5 elements per line.\n"
					+ "13:\tInitialize list and print number of deleted elements.\n\n"
					+ "100:\tShow this menu.\n"
					+ "0:\tExit program\n");
	}//End of printMenu
}//End of Oblig1
