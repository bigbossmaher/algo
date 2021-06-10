package assignments1b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6PowerSet {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(2);
		list.add(5);
		list.add(1);
		System.out.println(powerSet(list));

	}

	public static List<Set> powerSet(List<Integer> list) {
		List<Set> result = new ArrayList<>();
		result.add(new HashSet<Integer>());
		recursivePowerSet(list, result, 0);
		return result;
	}

	private static void recursivePowerSet(List<Integer> input, List<Set> result, int start) {
		if (start >= input.size())
			return;
		List<Set> curResult = new ArrayList<Set>();
		for (Set eachSet : result) {
			Set newSet = new HashSet<>();
			newSet.addAll(eachSet);
			newSet.add(input.get(start));
			curResult.add(newSet);
		}
		result.addAll(curResult);
		recursivePowerSet(input, result, start + 1);
	}
}
