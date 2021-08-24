package dev.vinothm.algorithms;


	import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;



	public class DNAHealth {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .collect(toList());

	        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        int s = Integer.parseInt(bufferedReader.readLine().trim());
	        
	        int[] minMax = {Integer.MAX_VALUE, Integer.MIN_VALUE};

	        IntStream.range(0, s).forEach(sItr -> {
	            try {
	                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	                int first = Integer.parseInt(firstMultipleInput[0]);

	                int last = Integer.parseInt(firstMultipleInput[1]);

	                String d = firstMultipleInput[2];
	                
	                var result = IntStream.rangeClosed(first, last)
	                    .reduce(0, (sum,i) -> {
	                        var count = 0;
	                        var gi = genes.get(i);
	                        var hi = health.get(i);
	                        var index = d.indexOf(gi);
	                        while (index >= 0) {
	                            count++;
	                            index = d.indexOf(gi, ++index);
	                        }
	                        return sum + count * hi;
	                    });
	                if (result < minMax[0]) minMax[0] = result;
	                if (result > minMax[1]) minMax[1] = result;
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });
	        System.out.println(minMax[0] + " " + minMax[1]);
	        bufferedReader.close();
	    }
	    
	}

