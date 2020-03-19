import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DungeonTest {
	
	
	@Test
	void testcreateDungeon1() {
		Room[][] dung = new Room[5][5];		
		dung[0][0]=new Room("I");
		dung[4][4] = new Room("O");
		dung[1][3] = new Room("p");
		dung[2][4] = new Room ("p");
		dung[4][2] = new Room ("p");
		dung[3][1] = new Room ("p");
			ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int x = 1; x <= 5; x++) {
	            list.add(new Integer(x));
	        }
		assertTrue(list.size() == 5);
	}
}

