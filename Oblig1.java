import java.util.Scanner;

public class Oblig1
{
	public static void main(String[] args)
	{
		//Declare variables for user interaction
		Scanner input = new Scanner(System.in);
		int option, data, target;
		Integer temp;

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
					target = input.nextInt();
					System.out.print("Integer to be added: ");
					data = input.nextInt();
					if(myList.addAfter(target, data))
						System.out.println(data + " added after " + target + ".\n");
					else
						System.out.println(target + " was not found, no integer added.\n");
					break;
				case 8:
					System.out.print("Enter integer to add in front of: ");
					target = input.nextInt();
					System.out.print("Integer to be added: ");
					data = input.nextInt();
					if(myList.addBefore(target, data))
						System.out.println(data + " added before " + target + ".\n");
					else
						System.out.println(target + " was not found, no integer added.\n");
					break;
				case 9:
					System.out.println("The list has " + myList.size()+" elements.\n");
					break;
				case 10:
					if(myList.checkCorrespondence())
						System.out.println("Element count is correct.\n");
					else
						System.out.println("The programmer made a mistake:"
										+  "\n'elementCount' and number of elements do not correspond!!");
					break;
				case 11:
					System.out.print("Enter integer to check for: ");
					data = input.nextInt();
					System.out.println("The number '"+ data + "' was found " + myList.occurences(data)+" times.\n");
					break;
				case 12:
					printArray(myList.toArray());
					System.out.println();
					break;
				case 13:
					int old = myList.clear();
					System.out.println("Initialized list. Removed " + old + " elements.");
					break;
				case 14:
					temp = myList.max();
					if(temp != null)
						System.out.println("Maximum value is " + temp);
					else
						System.out.println("List is empty.\n");
					break;
				case 15:
					temp = myList.min();
					if(temp != null)
						System.out.println("Minimum value is " + temp);
					else
						System.out.println("List is empty.\n");
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
							+ " 11:\tCount occurences of given value.\n"
							+ " 12:\tPrint list contents, 5 elements per line.\n"
							+ " 13:\tInitialize list and print number of deleted elements.\n"
							+ " 14:\tFind and print the value of the largest element in list.\n"
							+ " 15:\tFind and print the value of the smallest element in list.\n\n"
							+ "100:\tShow this menu.\n"
							+ "0:\tExit program\n"
							+ "==============================================================");
	}//End of printMenu
}//End of Oblig1
