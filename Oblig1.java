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
					System.out.print("Enter integer to remove (first occurrence): ");
					data = input.nextInt();
					if(myList.removeFirstOccurrence(data))
						System.out.println("First occurrence of " + data + " removed.\n");
					else
						System.out.println(data + " was not found in the list\n");
					break;
				case 4:
					System.out.print("Enter integer to remove: ");
					data = input.nextInt();
					if(myList.removeAll(data))
						System.out.println("Occurrences of " + data + " removed.\n");
					else
						System.out.println(data + " was not found in the list\n");
					break;
				case 5:
					System.out.print("Enter integer to add (beginning): ");
					data = input.nextInt();
					myList.addFirst(data);
					System.out.println(data + " inserted to the beginning of list.\n");
					break;
				case 6:
					System.out.print("Enter integer to add (end): ");
					data = input.nextInt();
					myList.addLast(data);
					System.out.println(data + " inserted to the end of list.\n");
					break;
				case 7:
					System.out.print("Enter integer to add after: ");
					int dataTarget = input.nextInt();
					System.out.print("Integer to be added: ");
					int dataValue = input.nextInt();
					if(myList.addAfter(dataTarget, dataValue))
						System.out.println(dataValue + " added after " + dataTarget + ".\n");
					else
						System.out.println(dataTarget + " was not found, no integer added.\n");
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
					System.out.println("Non-existent option. Type '100' for menu.\n");
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
		System.out.println("\n==============================================================\n"
							+" 1:\tDelete first element in list.\n"
							+ " 2:\tDelete last element in list.\n"
							+ " 3:\tDelete first occurence of given value.\n"
							+ " 4:\tDelete all occurences of given value. \n"
							+ " 5:\tInsert element with value at beginning of list.\n"
							+ " 6:\tInsert element with value at end of list.\n"
							+ " 7:\tInsert element after given value in list.\n"
							+ " 8:\tInsert element before given value in list.\n"
							+ " 9:\tPrint length of list.\n"
							+ " 10:\tCheck list length.\n"
							+ " 11:\tCount number of elements with value.\n"
							+ " 12:\tPrint list contents, 5 elements per line.\n"
							+ " 13:\tInitialize list and print number of deleted elements.\n"
							+ " 14:\tFind and print largest elements value.\n"
							+ " 15:\tFind and print smallest elements value.\n\n"
							+ "100:\tShow this menu.\n"
							+ "0:\tExit program\n"
							+ "==============================================================");
	}//End of printMenu
}//End of Oblig1
