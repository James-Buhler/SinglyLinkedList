package pac;

public class Driver {

	public static void main(String[] args) {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		//this is what adds the disciples names to the List
		list1.Append("Peter");
		list1.Append("Andrew");
		list1.Append("James");
		list1.Append("John");
		list1.Append("Philip");
		list1.Append("Bartholomew");
		list1.Append("Thomas");
		list1.Append("Matthew");
		list1.Append("James");
		list1.Append("Thaddaeus");
		list1.Append("Simon");
		list1.Append("Judas");
		list1.Print();
		//this removes the node that has Judas as the Data
		list1.Remove("Judas");
		list1.Print();
		//This Sorts the Strings alphabeticly
		list1.Sort();
		list1.Print();
		//This prints the string in Reverse
		list1.PrintReverse();
	}

}
