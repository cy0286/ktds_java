package hw0207;

public interface ContactAppInteface {

	public void remove(int contactIndex);
	public void addNewContact(Contact contact);
	public Contact getContactAt(int contactIndex);
	public void bubbleSort();
	public void selectionSort();
}
