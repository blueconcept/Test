import java.util.ArrayList;
import java.util.List;

/*
 * The purpose of this is to serve as the global list for the ListManager
 */
public class GlobalList<T> {

	protected List<T> itemList;
	protected ArrayList<Integer> countList;
	protected Boolean used;

	/*
	 * constructs the list with count list as a list of 0's 
	 */
	public GlobalList(List<T> item) {
		itemList = new ArrayList<T>();
		used = false;
		
		for(int i=0; i<item.size(); i++) {
			itemList.add(item.get(i));
		}
		
		
		countList = new ArrayList<Integer>();
		for(int i=0; i<itemList.size(); i++) {
			countList.add(0);
		}
	}
	
	/*
	 * Simulates an access of the element 
	 */
	public void access(int element) {
		incrementAt(element);
		for(int i=0; i<element; i++) {
			
			if(countList.get(i)<=countList.get(element)) {
				moveTo(element, i);
				break;
			}
		}
	}
	
	/*
	 * source will also be assumed to be greater then destination
	 */
	protected void moveTo(int source, int destination) {
		T temp = itemList.get(source);
		Integer tempCount = countList.get(source);
		
		for(int i=source; i>destination; i--) {
			itemList.set(i,itemList.get(i-1));
			countList.set(i, countList.get(i-1));
		}
		
		itemList.set(destination, temp);
		countList.set(destination, tempCount);
	}
	
	/*
	 * Increase the accessed count by 1 for at a given element at index
	 */
	public void incrementAt(int element) {
		countList.set(element, countList.get(element)+1);
	}
	
	/*
	 * 
	 */
	public int size() {
		return itemList.size();
	}
	
	/*
	 * Returns the String representation of the list
	 */
	public String toString() {
		StringBuilder stringOut = new StringBuilder();
		
		//Example: [(A, 4), (B, 3), (C, 2), (D, 2), (E, 2), (F, 2), (G, 2)]
		//Appends to string while incrementing through my lists then outputs the toString of the String Builder
		stringOut.append("[");
		for(int i=0; i<itemList.size();i++ ) {
			stringOut.append("(" + itemList.get(i) + ", " + countList.get(i) + ")");
			
			if(i<itemList.size()-1) {
				stringOut.append(", ");
			}
		}
		stringOut.append("]");
		return stringOut.toString();
	}

	/*
	 * Various accessors
	 */
	public T get(int i) {
		return itemList.get(i);
	}
	public int indexOf(T item) {
		return itemList.indexOf(item);
	}
	public void setUsed() {
		used = true;
	}
	public boolean getUsed() {
		return used;
	}
}
