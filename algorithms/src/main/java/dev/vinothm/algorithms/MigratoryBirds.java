package dev.vinothm.algorithms;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MigratoryBirds {

    public int getFrequentlySighted(List<Integer> arr) {
    	
    	return arr.stream()
    		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    		.entrySet().stream()
    			.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
    			.findFirst().get().getKey();

    }

}
