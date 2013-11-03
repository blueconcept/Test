/*
 * Dr. Marriot's Code
 */

import java.util.*;


/*
 * 
 */
public class Main {

	/*
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<Character>();
		
		for(char a = 'A'; a <= 'G'; a++){
			list.add(a);
		}
		
		ListManager<Character> lm = new ListManager<Character>(5, list);
		
		lm.Query(0, list.get(0)); //A
		lm.display();
		lm.Query(1, list.get(1)); //B
		lm.display(); 
		lm.Query(2, list.get(2));
		lm.display();
		lm.Query(3, list.get(3));
		lm.display();
		lm.Query(4, 'E');
		lm.display();
		lm.Query(0, 'F');
		lm.display();
		lm.Query(0, 'G');
		lm.display();
		lm.Query(3, 'G');
		lm.display();
		lm.Query(2, 'F');
		lm.display();
		lm.Query(1, 'E');
		lm.display();
		lm.Query(0, 'D');
		lm.display();
		lm.Query(4, 'C');
		lm.display();
		lm.Query(2, 'B');
		lm.display();
		lm.Query(1, 'A');
		lm.display();
		lm.Query(0, 'A');
		lm.display();
		lm.Query(3, 'A');
		lm.display();
		lm.Query(2, 'B');
		lm.display();
		lm.Query(3, 'A');
		lm.display();
		lm.Query(4, 'C');
		lm.display();
		lm.Query(3, 'A');
		lm.display();
		lm.Query(4, 'G');
		lm.display();

	}

}
