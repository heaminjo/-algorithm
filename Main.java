package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	class Solution {
	    public String[] solution(String[] players, String[] callings) {
			int index;
	    	List<String> p = new ArrayList<>(Arrays.asList(callings));
	    	String[] answer = {};
	    	for(int i=0;i<callings.length;i++) {
	    		index = p.indexOf(callings[i]);
	    		Collections.swap(p, i, i-1);
	    	}
	    	answer =p.toArray(new String[p.size()]);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		
	}

}
