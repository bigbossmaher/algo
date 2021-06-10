package assignment1a;

import java.util.LinkedList;

public class Problem4LinkedListSorting {

	public static void main(String[] args) {
		LinkedList<Integer> aList = new LinkedList<Integer>();
		aList.add(100);
		aList.add(50);
		aList.add(1);
		aList.add(90);
		sort(aList);
		System.out.println(aList);
	}

	public static void sort(LinkedList<Integer> list) {
		int len = list.size();
		int minIndex = 0;
		for(int i = 0; i < len-1; i++) {
			int firstMin = Integer.MAX_VALUE;
			for(int j = i; j < len; j++) {
				if(list.get(j) < firstMin) {
					firstMin = list.get(j);
					minIndex = j;
				}
			}
			int temp = list.get(i);
			list.set(minIndex,temp);
			list.set(i, firstMin);					
		}
	}

}
