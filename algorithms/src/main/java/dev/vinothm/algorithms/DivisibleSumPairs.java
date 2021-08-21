package dev.vinothm.algorithms;

import java.util.List;
import java.util.stream.IntStream;

public class DivisibleSumPairs {

	/**
	 * 
	 * @param k    {divider}
	 * @param ar   {input}
	 * @return int {count of Divisible Sum)
	 */
    public int divisibleSumPairs(int k, List<Integer> ar) {
    	if (ar == null || ar.size() < 2) {
    		return 0;
    	}
    	
    	return IntStream.range(0, ar.size())
    		.reduce(0, (count, i)
    				-> count + IntStream.range(i+1, ar.size())
    					.reduce(0, (sub,j)
    							-> {
    								System.out.println(ar.get(i)+ar.get(j));
    								return (ar.get(i)+ar.get(j)) % k == 0
    										? ++sub : sub;
    								}));
    }

	
}
