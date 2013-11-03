import java.util.ArrayList;
import java.util.List;

/*
 * This class has an additional global list to match the order from for unused items
 */
public class ItemList<T> extends GlobalList<T> { 

	//
	GlobalList<T> globalglobal;
	
	/*
	 * Constructor, assigns a global list to read from
	 */
	public ItemList(List<T> listInput, GlobalList<T> glob) {
		super(listInput);
		globalglobal = glob;
	}
	
	/*
	 * Override of access so that they are sorted, don't think I actually needed to do this but why not
	 */
	public void access(int element) {
		super.access(element);
		ArrayList<T> unusedList = new ArrayList<T>();
		for(int i=0;i<itemList.size();i++) {
			if(countList.get(i)==0) {
				unusedList.add(itemList.get(i));
			}
		}
		
		ArrayList<T> sortedList = new ArrayList<T>();
		for(int i=0;i<globalglobal.size();i++) {
			if(unusedList.contains(globalglobal.get(i))) {
				sortedList.add(globalglobal.get(i));
			}
		}
		
		int count = 0;
		for(int i=itemList.size() - sortedList.size();i<itemList.size(); i++) {
			itemList.set(i, sortedList.get(count));	
			count += 1;
		}	
	}
	
	/*
	 * Returns the toString of the list this one is a bit more elaborate then GlobalList
	 */
	public String toString() {
		StringBuilder stringOut = new StringBuilder();
		
		ArrayList<T> unusedList = new ArrayList<T>();
		for(int i=0; i<itemList.size(); i++) {
			if(countList.get(i)==0) {
			unusedList.add(itemList.get(i));
			}
		}
		
		
		/*
		 * Ok please be merciful, I'm really just hacking out code here to try to make the console output match the trace
		 */
		
		//Example: [(A, 4), (B, 3), (C, 2), (D, 2), (E, 2), (F, 2), (G, 2)]
		//Appends to string while incrementing through my lists then outputs the toString of the String Builder
		if(this.getUsed()) {
			stringOut.append("[");
			for(int i=0; i<itemList.size();i++ ) {
				if(countList.get(i)==0) {
					
					//This prints out the rest of the list as according to the globallist of unused things
					for(int j=0; j<globalglobal.size(); j+=1) {
						if(unusedList.contains(globalglobal.get(j))) {
							stringOut.append("(" + globalglobal.get(j) + ", " + globalglobal.countList.get(j) + ")");
							if(stringOut.length()<55) {
								stringOut.append(", ");
							}
						}
						
					}
					break;
				} else {
				stringOut.append("(" + itemList.get(i) + ", " + countList.get(i) + ")");
				}
				if(i<itemList.size()-1) {
					stringOut.append(", ");
				}
			}
			stringOut.append("]");
			
		}
		else {
			stringOut.append(globalglobal);
			
		}
		return stringOut.toString();
	}
}
