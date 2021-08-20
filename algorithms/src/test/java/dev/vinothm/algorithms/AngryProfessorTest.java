package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

class AngryProfessorTest {

	@Test
	void test() {
		var list = Arrays.asList(Arrays.asList(-93, -86, 49, -62, -90, -63, 40, 72, 11, 67),
						Arrays.asList(23, -35, -2, 58, -67, -56, -42, -73, -19, 37),
						Arrays.asList(13, 91, 56, -62, 96, -5, -84, -36, -46, -13),
						Arrays.asList(45, 67, 64, -50, -8, 78, 84, -51, 99, 60),
						Arrays.asList(26, 94, -95, 34, 67, -97, 17, 52, 1, 86),
						Arrays.asList(19, 29, -17, -71, -75, -27, -56, -53, 65, 83),
						Arrays.asList(-32, -3, -70, 8, -40, -96, -18, -46, -21, -79),
						Arrays.asList(-50, 0, 64, 14, -56, -91, -65, -36, 51, -28),
						Arrays.asList(-58, -29, -35, -18, 43, -28, -76, 43, -13, 6),
						Arrays.asList(88, -17, -96, 43, 83, 99, 25, 90, -39, 86));
		int[] input = {4,10,9,8,7,2,10,9,6,1};
		String[] result = {"NO","YES","YES",
				"YES","YES","NO","YES","YES",
				"NO","NO"};

		var professor = new AngryProfessor();
		assertEquals("YES", professor.cancelClass(3, Arrays.asList(-1, -3, 4, 2)));
		assertEquals("NO", professor.cancelClass(2, Arrays.asList(0,-1, 2, 1)));
		assertEquals("NO", professor.cancelClass(4, Arrays.asList(-93, -86, 49, -62, -90, -63, 40, 72, 11, 67)));
		var i = new AtomicInteger();
		for (var a : list) {
			assertEquals(result[i.get()], professor.cancelClass(input[i.get()], a));
			i.incrementAndGet();
		}
	}

}
