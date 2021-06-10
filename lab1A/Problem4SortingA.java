package assignment1a;

import java.util.ArrayList;
import java.util.List;

public class Problem4SortingA {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(199);
		arrayList.add(101);
		arrayList.add(50);
		arrayList.add(89);
		arrayList.add(0);
		sort(arrayList);
		System.out.println(arrayList);

	}

	public static void sort(ArrayList<Integer> list) {	
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
