package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CompareTheTripletsTest {

    @Test
    public void compareTriplets2() {
	assertIterableEquals(new CompareTheTriplets().compareTriplets2(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1)),
		Arrays.asList(1, 1));
    }

}
