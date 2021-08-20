package dev.vinothm.algorithms;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AngryProfessor {
	
	public String cancelClass(int k, List<Integer> a) {
    	var numOfStuInTime = new AtomicInteger();
    	a.stream()
    		.filter(t -> t <= 0)
    		.takeWhile(_t -> numOfStuInTime.get() < k)
    		.forEach(_t -> numOfStuInTime.incrementAndGet());

    	return numOfStuInTime.get() >= k ? "NO" : "YES";
	}

}
