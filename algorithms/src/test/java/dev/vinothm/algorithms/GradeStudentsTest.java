/**
 * 
 */
package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Vinoth Marimuthu
 *
 */
class GradeStudentsTest {

	/**
	 * Test method for {@link dev.vinothm.algorithms.GradeStudents#grade(java.util.List)}.
	 */
	@Test
	void testGrade() {
		var gradeStudents = new GradeStudents();
		assertEquals(gradeStudents.grade(List.of(73,67,38,33)), List.of(75,67,40,33));
	}

}
