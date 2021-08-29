package dev.vinothm.algorithms;

import java.util.LinkedList;
import java.util.List;

public class ClimbingLeaderboard {

    public static void main(String[] args) {
	List<Integer> ranked = List.of(100, 100, 50, 40, 40, 20, 10);
	List<Integer> player = List.of(5, 25, 50, 120);

	var result = new LinkedList<Integer>();
	var rank = 1;
	var rIndex = 0;
	var currentScore = -1;
	for (int i = player.size() - 1; i >= 0; i--) {
	    while (ranked.size() > rIndex && player.get(i) < ranked.get(rIndex)) {
		if (currentScore != ranked.get(rIndex)) {
		    rank++;
		    currentScore = ranked.get(rIndex);
		}
		rIndex++;
	    }
	    if (ranked.size() > rIndex && player.get(i) >= ranked.get(rIndex)) {
		result.addFirst(rank);
	    } else if (ranked.size() > rIndex && currentScore != ranked.get(rIndex)) {
		rank++;
		currentScore = ranked.get(rIndex);
	    } else {
		result.addFirst(rank);
		break;
	    }
	}

	result.forEach(System.out::println);
    }

}
