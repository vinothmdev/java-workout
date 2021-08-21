package dev.vinothm.algorithms;

import java.util.List;
import java.util.stream.Collectors;

public class GradeStudents {

	public List<Integer> grade(List<Integer> grades) {
		// 84 -> 85 -> 84 + (5 - 84 % 5)
		return grades.stream()
				.map(grade
						-> (grade >= 38 && grade % 5 > 2)
							? (grade + (5 - grade % 5))
							: grade).collect(Collectors.toList());
	}
	
}
