package dev.vinothm.algorithms;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SubarrayDivision {

    public int birthday(List<Integer> s, int d, int m) {
    	if (s == null || s.size() < m) {
    		return 0;
    	}
    	
    	var count = new AtomicInteger();
    	var total = new AtomicInteger();
    	// First window total
    	total.set(s.stream().limit(m).reduce(0, (sub, elm) -> sub + elm));
    	
    	if (total.get() == d) count.incrementAndGet();
    	IntStream.range(m, s.size()).forEach(i-> {
    		total.set(total.get() - s.get(i - m) + s.get(i));
    		if (total.get() == d) count.incrementAndGet();
    	});
    	
    	return count.get();
    }
}
