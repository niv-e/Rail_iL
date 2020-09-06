import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckTimeTest {

	@Test
	void checkTimeTest() {
		int hours = 10;
		int minutes = 30;
		Clock c = new Clock();
		boolean res = c.checkTime(hours, minutes);
		assertEquals(true, res);
	}

}
