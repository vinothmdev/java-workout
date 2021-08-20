package dev.vinothm.algorithms;

import java.util.List;

public class AngryProfessor {
	
	public String cancelClass(int k, List<Integer> a) {
        if (k >= 0 && a != null && a.size() >= k) {
            return a.stream()
                .filter(t -> t <= 0)
                .count() >= k
                    ? "NO"
                    : "YES";
        }
        return "YES";
	}

}
