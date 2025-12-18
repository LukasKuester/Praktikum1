package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BahnhofTest {
	Bahnhof bahnhof;
	@BeforeEach
	void setUp() throws Exception {
		String[] bahnen= {"rb","s"};
		bahnhof=new Bahnhof("Dortmund Oespel", "Dortmund", 2, 1993, bahnen);
	}

	@AfterEach
	void tearDown() throws Exception {
		bahnhof=null;
	}

	@Test
	void test() {
		assertTrue(bahnhof.getName().equals("Dortmund Oespel"));
		
		Throwable exc = assertThrows(IllegalArgumentException.class,()-> new Bahnhof("Dortmund Oespel", "Dortmund", 2, 1993, null));
	}

}
