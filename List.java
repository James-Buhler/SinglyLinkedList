package pac;

public interface List <T>{
	public void Append(T item);

	public void Prepend(T item);

	public boolean InsertAfter(MyNode<T> node, T item2);

	public boolean Remove(T item);

	public int Search(T item);

	public void Print();

	public void PrintReverse();

	public void Sort();

	public boolean IsEmpty();

	public int GetLength();
}