package assignment1a;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lab1.powerset.PowerSet;

public class Problem3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println();
		System.out.println(subsetSum(list, 5));
	}

	public static boolean subsetSum(List<Integer> list, Integer z) {
		List<Set<Integer>> powerset = PowerSet.powerSet(list);
		for (Set<Integer> set : powerset) {
			int sum = 0;
			for (int num : set) {
				sum += num;
			}
			if (sum == z)
				return true;
		}
		return false;
	}

}
