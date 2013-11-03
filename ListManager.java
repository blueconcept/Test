import java.util.ArrayList;
import java.util.List;

/*
 * Class to make the lists and print them with the Query operation
 */
public class ListManager<T> {
	
	int number_of_users;
	ArrayList<ItemList<T>> userList;
	GlobalList<T> globalList;
	
	/*
	 * Constructor that takes in the size of users and the item list to organize 
	 */
	public ListManager(int users, List<T> items) {
		userList = new ArrayList<ItemList<T>>();
		globalList = new GlobalList<T>(items);
		
		for(int i=0; i<users; i++) {
			userList.add(new ItemList<T>(items, globalList));
		}
	}
	
	/*
	 * Simulates an access on the list given a user index and Item index
	 */
	public void Query(int user, T item) {
		
		userList.get(user).access(userList.get(user).indexOf(item));
		userList.get(user).setUsed();
		globalList.access(globalList.indexOf(item));
		//User 2 queries C
		System.out.println("User " + user + " queries " + item);

	}
	
	/*
	 * prints out the lists and global list
	 */
	void display() {
		/*
		 * Global List: [(A, 1), (B, 0), (C, 0), (D, 0), (E, 0), (F, 0), (G, 0)]
		 * User 0: [(A, 1), (B, 0), (C, 0), (D, 0), (E, 0), (F, 0), (G, 0)]
		 */
		System.out.println("Global List: " + globalList);
		for(int i=0; i<userList.size(); i++) {
			System.out.println("User " + i + ":" + userList.get(i).toString());
		}
	}

}
