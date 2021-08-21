package dev.vinothm.algorithms;

import java.util.List;

public class BreakingTheRecords {
    public List<Integer> breakingRecords(List<Integer> scores) {
    	// Write your code here
    	if (scores != null && scores.size() > 1) {
    		// Initialize the count with the first value
    		Tracker min = new Tracker(scores.get(0));
    		Tracker max = new Tracker(scores.get(0));
    		scores.stream()
    			.forEach(score -> {
	    			if (score < min.score) min.update(score);
	    			if (score > max.score) max.update(score);
    			});
    		return List.of(max.count, min.count);
    	}
    	
    	return scores;
    }
    
}

class Tracker {
	int score;
	int count;
	
	Tracker(int score) {
		this.score = score;
	}
	
	public void update(int newScore) {
		this.score = newScore;
		this.count++;
	}
}
