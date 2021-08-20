package dev.vinothm.algorithms;

import java.util.stream.IntStream;

public class UtopianTree {
    public int estimateGrowth(int noOfCycles) {
        return IntStream.rangeClosed(0,noOfCycles)
                .reduce(0, (height, cycle)
                    -> (cycle % 2 == 0)
                        ? ++height
                        : height * 2);
    }
    
    public static void main(String...args) {
    	var tree = new UtopianTree();
    	for (int i = 0; i < 10; i ++) {
    		System.out.println(i + " " + tree.estimateGrowth(i));
    	}
    }
}