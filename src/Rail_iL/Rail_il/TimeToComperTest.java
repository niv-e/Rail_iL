package Rail_il;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeToComperTest {

	@Test
	void timeToComperTest() {
		Clock c1 = new Clock();
		c1.setTime("12:00");
		int res = c1.timeToCompare();
		assertEquals(1200,res);
		
		
	}

}
