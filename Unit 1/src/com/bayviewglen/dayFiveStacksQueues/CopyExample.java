package com.bayviewglen.dayFiveStacksQueues;

import java.util.Arrays;

public class CopyExample {

	public static void main(String[] args) {
		
		Object[] x = {1, 2, 3, 4};
		Object[] y = Arrays.copyOf(x, 10);
		
		System.out.println(Arrays.toString(y));
		
		//throw new ClassCastExepcetion(); // strings 

	}

}
