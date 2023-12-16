package pac;

public class SinglyLinkedList<T> implements List<T> {
	public MyNode<T> Head;
	public MyNode<T> Tail;
	public int Size;
	
	public SinglyLinkedList() {
		this.Head = null;
		this.Tail = null;
		this.Size = 0;
	}

	@Override
	public void Append(T item) {//this is what adds the disciples names to the List
		MyNode<T> node = new MyNode<T>(item);
		if (this.Head == null) {
			this.Head = node;
			this.Tail = node;
		} else {
			Tail.NextNode = node;
			Tail = node;
		}
		Size++;
	}

	@Override
	public void Prepend(T item) {
		MyNode<T> node = new MyNode<T>(item);
		if (this.Head == null) {
			this.Head = node;
			this.Tail = node;
		} else {
			node.NextNode = this.Head;
			this.Head = node;
		}
		Size++;
	}

	@Override
	public boolean InsertAfter(MyNode<T> node, T item) {
		MyNode<T> currNode = this.SearchNode(node.Data);
		if (currNode == null) {
			return false;
		} else {
			MyNode<T> newNode = new MyNode<T>();
			newNode.Data = item;
			MyNode<T> nextNode = currNode.NextNode;
			currNode.NextNode = newNode;
			newNode.NextNode = nextNode;
			this.Size++;
			return true;
		}
	}

	public MyNode<T> SearchNode(T n) {
		MyNode<T> currNode = this.Head;
		while (currNode != null) {
			if (currNode.Data == n) {
				return currNode;
			} else {
				currNode = currNode.NextNode;
			}
		}
		return null;
	}
	
	@Override
	public boolean Remove(T item) {//this removes the node that has Judas as the Data
		MyNode<T> previousNode = this.Head;
		MyNode<T> currNode = this.Head;
		int index = Search(item);
		if(index == -1) {
			return false;
		} else if(index == 0) {
			this.Head = currNode.NextNode;
			currNode.NextNode = null;
		} else {
			currNode = previousNode.NextNode;
			for(int i = 1; i < index; i++) {
				previousNode = currNode;
				currNode = previousNode.NextNode;
			}
			previousNode.NextNode = currNode.NextNode;
			currNode.NextNode = null;
			return true;
		}
		return false;
	}

	@Override
	public int Search(T item) {
		MyNode<T> currNode = this.Head;
		int count = 0;
		while (currNode != null) {
			if (currNode.Data == item) {
				return count;
			} else {
				currNode = currNode.NextNode;
			}
			count++;
		}
		return -1;
	}

	@Override
	public void Print() {
		MyNode<T> currNode = this.Head;
		while(currNode != null) {
			System.out.print(currNode.Data + " ");
			currNode = currNode.NextNode;
		}
		System.out.println();
	}

	@Override
	public void PrintReverse() {//This prints the string in Reverse
		SinglyLinkedList<T> temp = new SinglyLinkedList<T>();
		MyNode<T> currNode = this.Head;
		while(currNode != null) {
			temp.Prepend(currNode.Data);
			currNode = currNode.NextNode;
		}
		currNode = temp.Head;
		while(currNode != null) {
			System.out.print(currNode.Data + " ");
			currNode = currNode.NextNode;
		}
		System.out.println();
	}

	@Override
	public void Sort() {//This Sorts the Strings alphabeticly
		for(int i = 0; i < this.Size; i++) {
			MyNode<T> previousPreviousNode = this.Head;
			MyNode<T> previousNode = this.Head;
			MyNode<T> currNode = this.Head.NextNode;
			while(currNode != null) {
				if(compareTwoStrings(previousNode.Data.toString(), currNode.Data.toString(), 0) == 1) {
					if(previousNode == this.Head) {
						previousNode.NextNode = currNode.NextNode;
						currNode.NextNode = previousNode;
						this.Head = currNode;
					} else {
						previousPreviousNode.NextNode = currNode;
						previousNode.NextNode = currNode.NextNode;
						currNode.NextNode = previousNode;
					}
				}
				previousPreviousNode = previousNode;
				previousNode = currNode;
				currNode = currNode.NextNode;
			}
			this.Tail = previousNode;
		}
		
	}
	
	public static int compareTwoStrings(String s1, String s2, int index) {
		if(s1.length() == index || s2.length() == index) {
			if(s1.length() > s2.length()) {
				return 1;
			}
		} else if(s1.charAt(index) > s2.charAt(index)) {
			return 1;
		} else if (s1.charAt(index) == s2.charAt(index)) {
			return compareTwoStrings(s1, s2, index + 1);
		}
		return -1;
	}

	@Override
	public boolean IsEmpty() {
		return Size <= 0;
	}

	@Override
	public int GetLength() {
		return Size;
	}

}
