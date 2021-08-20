package dev.vinothm.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class CompareTheTriplets {

    public List<Integer> compareTriplets2(List<Integer> a, List<Integer> b) {
	List<Integer> result = Arrays.asList(0, 0);
	Function<Integer, Integer> index = (point) -> point > 0 ? 0 : 1;
	IntStream
		.range(0, 3)
		    .map(i -> a.get(i).compareTo(b.get(i)))
		    .filter(value -> value != 0)
		    .map(i -> index.apply(i))
		    .forEach(point -> result.set(point, result.get(point) + 1));
	return result;
    }

}
